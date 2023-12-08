package org.fcpay.service

import org.fcpay.controller.fcpay.response.ChargingResponse
import org.fcpay.controller.fcpay.response.PayResponse
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.fcpay.FcPayRepository
import org.fcpay.domain.fcpay.event.ChargingPayAlertEvent
import org.fcpay.domain.fcpay.service.PayChargingDomainService
import org.fcpay.domain.firmbanking.FirmBankingHistory
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.fcpay.domain.firmbanking.FirmBankingType
import org.fcpay.domain.franchisee.Franchisee
import org.fcpay.domain.franchisee.FranchiseeRepository
import org.fcpay.domain.payment.PaymentRepository
import org.fcpay.domain.slip.SlipRepository
import org.fcpay.gateway.firmbanking.FirmBakingHandler
import org.fcpay.service.command.ChargeCommand
import org.fcpay.service.command.PayCommand
import org.fcpay.service.exception.EntityNotFoundException
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PayUseCase (
    private val fcPayRepository: FcPayRepository,
    private val franchiseeRepository: FranchiseeRepository,
    private val slipRepository: SlipRepository,
    private val firmBakingHandler: FirmBakingHandler,
    private val firmBankingHistoryRepository: FirmBankingHistoryRepository,
    private val payChargingDomainService: PayChargingDomainService,
    private val paymentRepository: PaymentRepository,
    private val eventPublisher: ApplicationEventPublisher
){
    @Transactional
    fun pay(cmd: PayCommand): PayResponse {
        val payment = paymentRepository.find(cmd.paymentId) ?: throw EntityNotFoundException(PaymentRepository::class, cmd.paymentId.toString())
        val fcPay = fcPayRepository.find(cmd.userId) ?: throw EntityNotFoundException(Franchisee::class, cmd.userId)
        fcPay.pay(cmd.payAmount, payment)

        val franchisee = franchiseeRepository.find(cmd.franchiseeId) ?: throw EntityNotFoundException(Franchisee::class, cmd.franchiseeId.toString())
        slipRepository.save(franchisee.requestPayment(cmd.payAmount, fcPay, payment))

        return PayResponse(fcPay.amount)
    }

    @Transactional
    fun charge(cmd: ChargeCommand): ChargingResponse {
        val fcPay = fcPayRepository.find(cmd.userId) ?: throw EntityNotFoundException(FcPay::class, cmd.userId)

        val res = payChargingDomainService.chargeProcess(firmBakingHandler, fcPay, cmd.chargeAmount, firmBankingHistoryRepository)
        eventPublisher.publishEvent(ChargingPayAlertEvent(cmd.userId, res.chargedPay, res.result))

        return ChargingResponse(fcPay.amount)
    }
}
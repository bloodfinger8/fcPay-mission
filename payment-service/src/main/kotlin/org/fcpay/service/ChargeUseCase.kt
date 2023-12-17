package org.fcpay.service

import org.fcpay.controller.fcpay.response.ChargingResponse
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.fcpay.FcPayRepository
import org.fcpay.domain.fcpay.event.ChargingPayAlertEvent
import org.fcpay.domain.fcpay.service.PayChargingDomainService
import org.fcpay.service.command.ChargeCommand
import org.fcpay.service.exception.EntityNotFoundException
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChargeUseCase (
    private val fcPayRepository: FcPayRepository,
    private val payChargingDomainService: PayChargingDomainService,
    private val eventPublisher: ApplicationEventPublisher
){
    @Transactional
    fun charge(cmd: ChargeCommand): ChargingResponse {
        val fcPay = fcPayRepository.find(cmd.userId) ?: throw EntityNotFoundException(FcPay::class, cmd.userId)

        val res = payChargingDomainService.chargeProcess(fcPay, cmd.chargeAmount)
        eventPublisher.publishEvent(ChargingPayAlertEvent(cmd.userId, res.amount, res.result))

        return ChargingResponse(fcPay.amount)
    }
}
package org.fcpay.domain.fcpay.service

import org.fcpay.common.DomainService
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.fcpay.policy.FcPayChargingPolicy
import org.fcpay.domain.firmbanking.FirmBankingHistory
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.fcpay.gateway.external.firmbanking.FirmBakingHandler
import org.fcpay.gateway.external.firmbanking.res.FirmBankingChargeResDTO
import org.fcpay.service.exception.FirmBankingException
import java.lang.IllegalArgumentException

@DomainService
class PayChargingDomainService(
    private val firmBakingHandler: FirmBakingHandler,
    private val firmBankingHistoryRepository: FirmBankingHistoryRepository
) {
    fun chargeProcess(fcPay: FcPay, chargeAmount: Long): ChargeProcessResponse {
        if(!FcPayChargingPolicy.isMinimumChargingPrice(chargeAmount))
            throw IllegalArgumentException("최소 충전 금액은 ${FcPayChargingPolicy.MINIMUM_CHARGING_PRICE}원 입니다.")

        val res: FirmBankingChargeResDTO = firmBakingHandler.requestExternalFirmBanking(chargeAmount) ?: throw FirmBankingException()

        firmBankingHistoryRepository.write(FirmBankingHistory.create(res.amount.toLong(), fcPay.userId, res.result))
        fcPay.charge(res.amount.toLong(), res.result)
        return ChargeProcessResponse(res.result, res.amount.toLong())
    }
}
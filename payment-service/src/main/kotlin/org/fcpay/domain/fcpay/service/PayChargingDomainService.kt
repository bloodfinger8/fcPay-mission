package org.fcpay.domain.fcpay.service

import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.fcpay.policy.FcPayChargingPolicy
import org.fcpay.gateway.firmbanking.FirmBakingHandler
import org.fcpay.gateway.firmbanking.result.FirmBankingResult
import org.fcpay.service.exception.FirmBankingException
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class PayChargingDomainService {
    fun chargeProcess(firmBakingHandler: FirmBakingHandler, fcPay: FcPay, chargeAmount: Long): FirmBankingResult {
        if(!FcPayChargingPolicy.isMinimumChargingPrice(chargeAmount))
            throw IllegalArgumentException("최소 충전 금액은 ${FcPayChargingPolicy.MINIMUM_CHARGING_PRICE}원 입니다.")

        val res = firmBakingHandler.requestExternalFirmBanking(chargeAmount) ?: throw FirmBankingException()
        fcPay.charge(res.chargedPay, res.result)
        return res
    }
}
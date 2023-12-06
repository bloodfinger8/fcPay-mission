package org.fcpay.gateway.firmbanking

import org.fcpay.domain.firmbanking.event.FirmBankingChargingEvent
import org.fcpay.gateway.firmbanking.result.FirmBankingResult
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class BankAccountAdapter(
    private  val eventPublisher: ApplicationEventPublisher
): FirmBakingHandler {
    override fun requestExternalFirmBanking(chargingPay: Long): FirmBankingResult? {
        // 외부 펌뱅킹 시스템 호출을 통해 금액 충전
        eventPublisher.publishEvent(FirmBankingChargingEvent("success"))
        return FirmBankingResult(true, chargingPay)
    }
}
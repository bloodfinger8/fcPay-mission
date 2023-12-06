package org.fcpay.domain.fcpay.service

import org.fcpay.gateway.firmbanking.FirmBakingHandler
import org.fcpay.gateway.firmbanking.result.FirmBankingResult

class FirmBankingSpy: FirmBakingHandler {
    override fun requestExternalFirmBanking(chargingPay: Long): FirmBankingResult? {
        return FirmBankingResult(true, chargingPay)
    }
}
package org.fcpay.domain.fcpay.service

import org.fcpay.gateway.external.firmbanking.FirmBakingHandler
import org.fcpay.gateway.external.firmbanking.res.FirmBankingChargeResDTO

class FirmBankingSpy: FirmBakingHandler {
    override fun requestExternalFirmBanking(amount: Long): FirmBankingChargeResDTO {
        return FirmBankingChargeResDTO(true, amount.toDouble())
    }
}
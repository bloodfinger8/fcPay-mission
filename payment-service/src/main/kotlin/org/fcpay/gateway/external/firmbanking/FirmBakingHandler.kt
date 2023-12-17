package org.fcpay.gateway.external.firmbanking

import org.fcpay.gateway.external.firmbanking.res.FirmBankingChargeResDTO

interface FirmBakingHandler {
    fun requestExternalFirmBanking(amount: Long): FirmBankingChargeResDTO
}
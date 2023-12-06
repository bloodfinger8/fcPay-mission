package org.fcpay.gateway.firmbanking

import org.fcpay.gateway.firmbanking.result.FirmBankingResult

interface FirmBakingHandler {
    fun requestExternalFirmBanking(chargingPay: Long): FirmBankingResult?
}
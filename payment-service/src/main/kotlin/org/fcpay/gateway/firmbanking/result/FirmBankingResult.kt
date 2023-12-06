package org.fcpay.gateway.firmbanking.result

data class FirmBankingResult(
    val result: Boolean,
    val chargedPay: Long
)
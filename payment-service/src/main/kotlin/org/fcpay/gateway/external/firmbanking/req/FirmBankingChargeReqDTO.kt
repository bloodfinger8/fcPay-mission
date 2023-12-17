package org.fcpay.gateway.external.firmbanking.req

data class FirmBankingChargeReqDTO(
    val amount: Double,
) {
    constructor() : this(0.0)
}
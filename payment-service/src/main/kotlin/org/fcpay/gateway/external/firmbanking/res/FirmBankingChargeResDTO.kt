package org.fcpay.gateway.external.firmbanking.res

data class FirmBankingChargeResDTO(
    val result: Boolean,
    val amount: Double
) {
    constructor() : this(false, 0.0)
}
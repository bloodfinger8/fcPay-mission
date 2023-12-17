package org.fcpay.service.command


data class ChargeCommand(
    val userId: String,
    val chargeAmount: Long
) {
}

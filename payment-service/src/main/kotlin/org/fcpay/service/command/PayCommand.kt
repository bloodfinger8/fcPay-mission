package org.fcpay.service.command

data class PayCommand (
    val userId: String,
    val paymentId: Long,
    val payAmount: Long,
    val franchiseeId: Long
)
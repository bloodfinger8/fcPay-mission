package org.fcpay.controller.fcpay.request

import org.fcpay.service.command.PayCommand

data class PayRequest (
    val paymentId: Long,
    val payAmount: Long,
    val franchiseeId: Long,
) {
    fun toCmd(userId: String): PayCommand {
        return PayCommand(
            userId,
            paymentId,
            payAmount,
            franchiseeId
        )
    }
}
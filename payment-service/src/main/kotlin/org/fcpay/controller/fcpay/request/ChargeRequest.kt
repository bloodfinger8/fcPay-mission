package org.fcpay.controller.fcpay.request

import org.fcpay.service.command.ChargeCommand

data class ChargeRequest(
    val chargeAmount: Long
) {
    fun toCmd(userId: String): ChargeCommand {
        return ChargeCommand(userId, chargeAmount)
    }
}

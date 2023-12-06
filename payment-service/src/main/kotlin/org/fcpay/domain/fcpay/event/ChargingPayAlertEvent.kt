package org.fcpay.domain.fcpay.event

class ChargingPayAlertEvent (
    val userId: String,
    val chargingPay: Long,
    val chargingPayResult: Boolean
)
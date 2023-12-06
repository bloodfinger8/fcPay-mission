package org.fcpay.service

import org.fcpay.domain.fcpay.event.ChargingPayAlertEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener

@Component
class PayEventListener() {
    @TransactionalEventListener
    fun onPayEvent(event: ChargingPayAlertEvent) {
        println("${event.userId}님  ${event.chargingPay}원 금액을 충전 했습니다.")
    }
}
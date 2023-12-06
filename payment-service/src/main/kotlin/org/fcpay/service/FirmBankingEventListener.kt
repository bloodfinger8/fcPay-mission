package org.fcpay.service

import org.fcpay.domain.firmbanking.event.FirmBankingChargingEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener

@Component
class FirmBankingEventListener {
    @TransactionalEventListener
    fun chargingEvent(event: FirmBankingChargingEvent) {
        println("firmBanking success http : ${event.data}")
    }
}
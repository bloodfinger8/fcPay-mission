package org.fcpay.service

import org.fcpay.controller.banking.response.BankingChargeResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankingUseCase {
    @Transactional
    fun banking(amount: Long): BankingChargeResponse {
        println("firmbanking charge")
        return BankingChargeResponse(true, amount.toDouble())
    }
}
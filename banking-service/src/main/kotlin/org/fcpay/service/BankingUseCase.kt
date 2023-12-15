package org.fcpay.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankingUseCase (
){
    @Transactional
    fun banking(): Boolean {
        println("firmbanking charge")
        return true
    }
}
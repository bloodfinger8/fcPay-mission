package org.fcpay.gateway.repository.firmbankingHistory

import org.fcpay.domain.firmbanking.FirmBankingHistory
import org.springframework.data.jpa.repository.JpaRepository

interface FirmBankingHistoryAdapter : JpaRepository<FirmBankingHistory, Long> {
    fun save(firmBankingHistory: FirmBankingHistory): FirmBankingHistory
}
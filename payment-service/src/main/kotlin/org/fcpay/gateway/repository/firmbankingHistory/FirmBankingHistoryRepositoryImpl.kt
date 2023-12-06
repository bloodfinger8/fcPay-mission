package org.fcpay.gateway.repository.firmbankingHistory

import org.fcpay.domain.firmbanking.FirmBankingHistory
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.springframework.stereotype.Repository

@Repository
class FirmBankingHistoryRepositoryImpl(
    private val adapter: FirmBankingHistoryAdapter
) : FirmBankingHistoryRepository {
    override fun write(firmBankingHistory: FirmBankingHistory): FirmBankingHistory {
        return adapter.save(firmBankingHistory)
    }
}
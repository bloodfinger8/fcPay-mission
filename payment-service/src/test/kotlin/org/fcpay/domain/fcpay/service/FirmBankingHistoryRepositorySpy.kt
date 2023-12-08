package org.fcpay.domain.fcpay.service

import org.fcpay.domain.firmbanking.FirmBankingHistory
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.springframework.stereotype.Repository

@Repository
class FirmBankingHistoryRepositorySpy : FirmBankingHistoryRepository{
    override fun write(firmBanking: FirmBankingHistory): FirmBankingHistory {
        return firmBanking
    }
}
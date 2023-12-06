package org.fcpay.domain.firmbanking

interface FirmBankingHistoryRepository {
    fun write(firmBanking: FirmBankingHistory): FirmBankingHistory
}
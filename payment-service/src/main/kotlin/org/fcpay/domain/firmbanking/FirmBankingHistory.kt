package org.fcpay.domain.firmbanking

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.fcpay.domain.BaseTimeEntity

@Entity
class FirmBankingHistory private constructor(
    val amount: Long,
    @Enumerated(EnumType.STRING)
    val firmBankingType: FirmBankingType,
    val sender: String,
    val receiver: String? = null,
    val result: Boolean
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    companion object {
        fun create(amount: Long, sender: String, result: Boolean): FirmBankingHistory {
            return FirmBankingHistory(amount, FirmBankingType.PAY_CHARGING, sender, null, result)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FirmBankingHistory

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
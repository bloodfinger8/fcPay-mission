package org.fcpay.domain.franchisee

import jakarta.persistence.*
import org.fcpay.domain.BaseTimeEntity

@Entity
class CommissionRate (
    private val rate: Double
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    fun calculateCommission(amount: Long): Double {
        return amount * rate
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommissionRate

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}
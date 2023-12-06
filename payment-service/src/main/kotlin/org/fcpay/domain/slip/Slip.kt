package org.fcpay.domain.slip

import jakarta.persistence.*
import org.fcpay.domain.BaseTimeEntity
import java.time.LocalDateTime

@Entity
class Slip (
    @Column(name = "amount")
    val amount: Long,
    val userId: String,
    val franchiseeId: Long
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Slip

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
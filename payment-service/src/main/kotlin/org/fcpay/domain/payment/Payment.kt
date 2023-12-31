package org.fcpay.domain.payment

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.fcpay.domain.BaseTimeEntity
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

@Entity
class Payment(
    @Enumerated(EnumType.STRING)
    var paymentStatus: PaymentStatus,
    val amount: Long,
    val franchiseeId: Long,
    val userId: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    fun complete() {
        isCanBeCompleted()
        this.paymentStatus = PaymentStatus.PAYMENT_COMPLETED
        this.updatedAt = LocalDateTime.now()
    }

    private fun isCanBeCompleted() {
        if(!this.paymentStatus.canNext(PaymentStatus.PAYMENT_COMPLETED)) {
            throw IllegalArgumentException("결제가 완료되지 않은 요청입니다.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Payment

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
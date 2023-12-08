package org.fcpay.domain.franchisee

import jakarta.persistence.*
import org.fcpay.domain.BaseTimeEntity
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.payment.Payment
import org.fcpay.domain.slip.Slip
import java.time.LocalDateTime

@Entity
class Franchisee (
    @Embedded
    val franchiseeInfo: FranchiseeInfo,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val commissionRate: CommissionRate
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    fun requestPayment(amount: Long, fcPay: FcPay, payment: Payment): Slip {
        payAmountCheck(payment, amount)
        return generateSlip(amount, fcPay)
    }

    private fun payAmountCheck(payment: Payment, amount: Long) {
        if (payment.amount != amount)
            throw IllegalArgumentException("결제 요청 금액과 결제 금액이 일치하지 않습니다.")
    }

    private fun generateSlip(amount: Long, fcPay: FcPay): Slip {
        return Slip(amount, fcPay.userId, id!!)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Franchisee

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}
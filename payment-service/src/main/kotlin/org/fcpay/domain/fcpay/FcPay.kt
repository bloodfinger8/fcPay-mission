package org.fcpay.domain.fcpay

import jakarta.persistence.*
import org.fcpay.domain.BaseTimeEntity
import org.fcpay.domain.payment.Payment

@Entity
class FcPay (
    @Column(name = "user_id")
    val userId: String,
    @Column(name = "amount")
    var amount: Long
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Version
    var version: Int = 0

    private fun canPayMoney(payAmount: Long): Boolean {
        return amount >= payAmount
    }

    fun pay(amount: Long, payment: Payment) {
        require(canPayMoney(amount)) { "결제 금액이 부족합니다." }
        payment.complete()
        this.amount -= amount
    }

    fun charge(chargingPay: Long, result: Boolean) {
        check(result) { "firmBanking system 장애가 발생했습니다." }
        this.amount += chargingPay
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FcPay

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
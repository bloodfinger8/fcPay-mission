package org.fcpay.domain.fcpay

import io.kotest.core.spec.style.FunSpec
import org.fcpay.domain.payment.Payment
import org.fcpay.domain.payment.PaymentStatus
import org.junit.jupiter.api.assertThrows

class PayTest : FunSpec({
    test("fcPay 머니가 결제 금액보다 적을때 예외 발생") {
        val payment = Payment(PaymentStatus.PAYMENT_REQUESTED, 10000, 1, "test")
        val fcPay = FcPay("test", 1000)
        assertThrows<IllegalArgumentException> {
            fcPay.pay(10000, payment)
        }
    }

    test("외부 펌뱅킹 시스템에서 충전 실패시 예외 발생") {
        val fcPay = FcPay("test", 1000)
        assertThrows<IllegalStateException> {
            fcPay.charge(10000, false)
        }
    }
})
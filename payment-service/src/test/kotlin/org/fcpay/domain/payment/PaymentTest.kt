package org.fcpay.domain.payment

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class PaymentTest() : FunSpec({
    test("한번 결제된 요청은 다시 성공할 수 없다.") {
        val payment = payment(PaymentStatus.PAYMENT_COMPLETED)
        assertThrows<IllegalArgumentException> {
            payment.complete()
        }
    }

    test("결제 완료시 상태값이 완료로 변경된다.") {
        val payment = payment(PaymentStatus.PAYMENT_REQUESTED)
        payment.complete()
        payment.paymentStatus shouldBe PaymentStatus.PAYMENT_COMPLETED
    }
})

private fun payment(status: PaymentStatus) = Payment(status, 10000, 1, "test")
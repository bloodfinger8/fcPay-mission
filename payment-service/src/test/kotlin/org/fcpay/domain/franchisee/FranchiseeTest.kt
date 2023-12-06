package org.fcpay.domain.franchisee

import io.kotest.core.spec.style.FunSpec
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.payment.Payment
import org.fcpay.domain.payment.PaymentStatus
import org.junit.jupiter.api.assertThrows

class FranchiseeTest(): FunSpec({
    test("프랜차이즈 전표와 결제 금액 불일치시 예외 발생") {
        val paymentAmount = 10000L
        val requestAmount = 10002L
        val franchisee = Franchisee(FranchiseeInfo("test", "address", "010-1234-5678"))

        assertThrows<IllegalArgumentException> {
            franchisee.requestPayment(
                requestAmount,
                FcPay("test", 10000),
                Payment(PaymentStatus.PAYMENT_COMPLETED, paymentAmount, 1, "test")
            )
        }
    }
})



package org.fcpay.domain.payment

enum class PaymentStatus(val description: String) {
    PAYMENT_REQUESTED("결제 대기"),
    PAYMENT_COMPLETED("결제 완료"),
    PAYMENT_FAIL("결제 실패");

    fun canNext(next: PaymentStatus?): Boolean {
        return when (this) {
            PAYMENT_REQUESTED -> next == PAYMENT_COMPLETED || next == PAYMENT_FAIL
            PAYMENT_COMPLETED -> false
            PAYMENT_FAIL -> false
        }
    }
}
package org.fcpay.gateway.repository.payment

import org.fcpay.domain.payment.Payment
import org.springframework.data.jpa.repository.JpaRepository


interface PaymentRepositoryAdapter : JpaRepository<Payment, Long> {
}
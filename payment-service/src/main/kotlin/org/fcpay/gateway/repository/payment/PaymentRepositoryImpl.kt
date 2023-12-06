package org.fcpay.gateway.repository.payment

import org.fcpay.domain.payment.Payment
import org.fcpay.domain.payment.PaymentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(
    private val adapter: PaymentRepositoryAdapter
) : PaymentRepository {
    override fun find(id: Long): Payment? {
        return adapter.findByIdOrNull(id)
    }
}
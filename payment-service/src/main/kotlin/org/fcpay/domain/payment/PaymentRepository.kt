package org.fcpay.domain.payment

interface PaymentRepository {
    fun find(id: Long): Payment?
}
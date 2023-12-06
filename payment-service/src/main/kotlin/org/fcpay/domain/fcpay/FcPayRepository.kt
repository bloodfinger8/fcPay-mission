package org.fcpay.domain.fcpay

interface FcPayRepository {
    fun find(id: String): FcPay?
}
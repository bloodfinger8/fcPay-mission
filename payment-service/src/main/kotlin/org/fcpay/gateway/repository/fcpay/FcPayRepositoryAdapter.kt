package org.fcpay.gateway.repository.fcpay

import org.fcpay.domain.fcpay.FcPay
import org.springframework.data.jpa.repository.JpaRepository

interface FcPayRepositoryAdapter: JpaRepository<FcPay, Long> {
    fun findByUserId(userId: String): FcPay?
}
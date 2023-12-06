package org.fcpay.gateway.repository.fcpay

import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.fcpay.FcPayRepository
import org.springframework.stereotype.Repository

@Repository
class FcPayRepositoryImpl(
    private val adapter: FcPayRepositoryAdapter
): FcPayRepository {
    override fun find(id: String): FcPay? {
        return adapter.findByUserId(id)
    }
}
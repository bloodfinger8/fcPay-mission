package org.fcpay.gateway.repository.slip

import org.fcpay.domain.slip.Slip
import org.fcpay.domain.slip.SlipRepository
import org.springframework.stereotype.Repository

@Repository
class SlipRepositoryImpl(
    private val adapter: SlipRepositoryAdapter
): SlipRepository {
    override fun save(slip: Slip): Slip {
        return adapter.save(slip)
    }

}
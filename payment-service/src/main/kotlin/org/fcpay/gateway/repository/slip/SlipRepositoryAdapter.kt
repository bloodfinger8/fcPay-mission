package org.fcpay.gateway.repository.slip

import org.fcpay.domain.slip.Slip
import org.springframework.data.jpa.repository.JpaRepository

interface SlipRepositoryAdapter : JpaRepository<Slip, Long> {
    fun save(slip: Slip): Slip
}
package org.fcpay.domain.slip

interface SlipRepository {
    fun save(slip: Slip): Slip
}
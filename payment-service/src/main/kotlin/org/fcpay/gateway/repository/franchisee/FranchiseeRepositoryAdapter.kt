package org.fcpay.gateway.repository.franchisee

import org.fcpay.domain.franchisee.Franchisee
import org.springframework.data.jpa.repository.JpaRepository

interface FranchiseeRepositoryAdapter : JpaRepository<Franchisee, Long> {
    fun save(franchisee: Franchisee): Franchisee
}
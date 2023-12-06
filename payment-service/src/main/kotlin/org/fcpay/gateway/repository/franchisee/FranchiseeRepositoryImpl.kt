package org.fcpay.gateway.repository.franchisee

import org.fcpay.domain.franchisee.Franchisee
import org.fcpay.domain.franchisee.FranchiseeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class FranchiseeRepositoryImpl(
    private val adapter: FranchiseeRepositoryAdapter
): FranchiseeRepository {
    override fun find(id: Long): Franchisee? {
        return adapter.findByIdOrNull(id)
    }

    override fun save(franchisee: Franchisee): Franchisee {
        return adapter.save(franchisee)
    }
}
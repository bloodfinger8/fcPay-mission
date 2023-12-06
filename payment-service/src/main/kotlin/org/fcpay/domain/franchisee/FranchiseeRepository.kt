package org.fcpay.domain.franchisee

interface FranchiseeRepository {
    fun find(id: Long): Franchisee?
    fun save(franchisee: Franchisee): Franchisee
}
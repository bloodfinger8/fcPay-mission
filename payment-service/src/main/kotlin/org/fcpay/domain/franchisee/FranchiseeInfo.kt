package org.fcpay.domain.franchisee

import jakarta.persistence.Embeddable

@Embeddable
class FranchiseeInfo (
    val name: String,
    val address: String,
    val phoneNumber: String
)
package org.fcpay.domain.account

import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated


@Embeddable
class AccountInfo (
    val amount: Long,
    val bankName: String,
    val bankCode: String,
    val accountNumber: String,
    @Enumerated(EnumType.STRING)
    val accountStatus: AccountStatus
)
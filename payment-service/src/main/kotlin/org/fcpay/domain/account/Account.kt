package org.fcpay.domain.account

import jakarta.persistence.*
import org.fcpay.domain.BaseTimeEntity
import java.time.LocalDateTime

@Entity
class Account (
    @Column(name = "user_id")
    val userId: String,
    @Embedded
    val accountInfo: AccountInfo
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
}
package org.fcpay.service

import io.kotest.core.spec.style.FunSpec
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class ServiceEnvironmentInitTestSpec(body: FunSpec.() -> Unit = {}) : FunSpec(body) {
    @Autowired
    lateinit var firmBankingHistoryRepository: FirmBankingHistoryRepository
}
package org.fcpay.domain.fcpay.service

import io.kotest.core.spec.style.FunSpec
import org.fcpay.domain.fcpay.FcPay
import org.junit.jupiter.api.assertThrows

class PayChargingDomainServiceTest: FunSpec({
    test("충전 최소 금액 1만원 이하 테스트") {
        val payChargingDomainService = PayChargingDomainService()
        assertThrows<IllegalArgumentException> {
            payChargingDomainService.chargeProcess(
                firmBakingHandler = FirmBankingSpy(),
                fcPay = FcPay("test", 1000),
                chargeAmount = 1000,
                firmBankingHistoryRepository = FirmBankingHistoryRepositorySpy()
            )
        }
    }
})
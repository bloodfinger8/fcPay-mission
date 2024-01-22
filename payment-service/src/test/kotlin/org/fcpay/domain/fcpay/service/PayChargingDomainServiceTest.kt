package org.fcpay.domain.fcpay.service

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.fcpay.domain.fcpay.FcPay
import org.fcpay.domain.firmbanking.FirmBankingHistoryRepository
import org.fcpay.gateway.external.firmbanking.FirmBakingHandler
import org.fcpay.gateway.external.firmbanking.res.FirmBankingChargeResDTO
import org.fcpay.service.ServiceEnvironmentInitTestSpec
import org.junit.jupiter.api.assertThrows

class PayChargingDomainServiceTest(
    override var firmBankingHistoryRepository: FirmBankingHistoryRepository
): ServiceEnvironmentInitTestSpec({
    test("충전 최소 금액 1만원 이상 충전시 정상적으로 충전") {
        val firmBankingMock = mockk<FirmBakingHandler>()
        every { firmBankingMock.requestExternalFirmBanking(10000) } returns FirmBankingChargeResDTO(true, 10000.0)
        val payChargingDomainService = PayChargingDomainService(firmBankingMock, firmBankingHistoryRepository)


        val res = payChargingDomainService.chargeProcess(
            fcPay = FcPay("test", 1000),
            chargeAmount = 10000
        )

        res.amount shouldBe 10000
        res.result shouldBe true
    }

    test("충전 최소 금액 1만원 이하 충전시 IllegalArgumentException 발생") {
        val firmBankingMock = mockk<FirmBakingHandler>()
        val payChargingDomainService = PayChargingDomainService(firmBankingMock, firmBankingHistoryRepository)

        assertThrows<IllegalArgumentException> {
            payChargingDomainService.chargeProcess(
                fcPay = FcPay("test", 1000),
                chargeAmount = 1000
            )
        }
    }
})
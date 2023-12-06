package org.fcpay.domain.fcpay.policy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FcPayChargingPolicyTest: FunSpec({
    test("최소 금액 정책 검증") {

        val test = FcPayChargingPolicy.calculate(5000, 6000)
        val test2 = FcPayChargingPolicy.calculate(20000, 40000)
        val test3 = FcPayChargingPolicy.calculate(5000, 3000)

        test shouldBe 10000
        test2 shouldBe 20000
        test3 shouldBe 0
    }
})
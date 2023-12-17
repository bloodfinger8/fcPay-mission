package org.fcpay.controller.banking

import org.fcpay.controller.banking.request.BankingChargeRequest
import org.fcpay.controller.banking.response.BankingChargeResponse
import org.fcpay.service.BankingUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class BankingController (
    private val useCase: BankingUseCase
) {
    @PostMapping("/api/v1/charge")
    fun pay(
        @RequestHeader("X-TEMP-USER-ID") userId: String,
        @RequestBody req: BankingChargeRequest
    ): ResponseEntity<BankingChargeResponse> {
        val result = useCase.banking(req.amount)
        return ResponseEntity.ok(result)
    }
}
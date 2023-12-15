package org.fcpay.controller.banking

import org.fcpay.service.BankingUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class BankingController (
    private val useCase: BankingUseCase
) {
    @PostMapping("/banking")
    fun pay(
        @RequestHeader("X-TEMP-USER-ID") userId: String
    ): ResponseEntity<Boolean> {
        val result = useCase.banking()
        return ResponseEntity.ok(result)
    }
}
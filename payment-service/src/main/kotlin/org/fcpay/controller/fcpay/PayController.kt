package org.fcpay.controller.fcpay

import org.fcpay.controller.fcpay.request.ChargeRequest
import org.fcpay.controller.fcpay.request.PayRequest
import org.fcpay.service.PayUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class PayController (
    private val useCase: PayUseCase
) {
    @PostMapping("/pay")
    fun pay(
        @RequestHeader("X-USER-ID") userId: String,
        @RequestBody req: PayRequest
    ): ResponseEntity<Boolean> {
        val result = useCase.pay(req.toCmd(userId))
        return ResponseEntity.ok(result)
    }

    @PostMapping("/charge")
    fun charge(
        @RequestHeader("X-USER-ID") userId: String,
        @RequestBody req: ChargeRequest
    ): ResponseEntity<Boolean> {
        val result = useCase.charge(req.toCmd(userId))
        return ResponseEntity.ok(result)
    }
}
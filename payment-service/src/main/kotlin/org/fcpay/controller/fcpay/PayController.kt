package org.fcpay.controller.fcpay

import org.fcpay.controller.fcpay.request.ChargeRequest
import org.fcpay.controller.fcpay.request.PayRequest
import org.fcpay.controller.fcpay.response.ChargingResponse
import org.fcpay.controller.fcpay.response.PayResponse
import org.fcpay.service.ChargeUseCase
import org.fcpay.service.PayUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class PayController (
    private val payUseCase: PayUseCase,
    private val chargeUseCase: ChargeUseCase
) {
    @PostMapping("/pay")
    fun pay(
        @RequestHeader("X-TEMP-USER-ID") userId: String,
        @RequestBody req: PayRequest
    ): ResponseEntity<PayResponse> {
        val result = payUseCase.pay(req.toCmd(userId))
        return ResponseEntity.ok(result)
    }

    @PostMapping("/charge")
    fun charge(
        @RequestHeader("X-TEMP-USER-ID") userId: String,
        @RequestBody req: ChargeRequest
    ): ResponseEntity<ChargingResponse> {
        val result = chargeUseCase.charge(req.toCmd(userId))
        return ResponseEntity.ok(result)
    }
}
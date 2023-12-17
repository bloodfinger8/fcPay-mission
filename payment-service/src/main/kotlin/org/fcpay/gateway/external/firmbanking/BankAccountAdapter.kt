package org.fcpay.gateway.external.firmbanking

import com.fasterxml.jackson.databind.ObjectMapper
import org.fcpay.common.CommonHttpClient
import org.fcpay.gateway.external.firmbanking.req.FirmBankingChargeReqDTO
import org.fcpay.gateway.external.firmbanking.res.FirmBankingChargeResDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder

@Component
class BankAccountAdapter(
    private val client : CommonHttpClient,
    @Value("\${server.banking-service.url}")
    private val bankingUrl: String
): FirmBakingHandler {
    override fun requestExternalFirmBanking(amount: Long): FirmBankingChargeResDTO {
        val uri = UriComponentsBuilder
            .fromHttpUrl(bankingUrl)
            .path("/api/v1/charge")
            .build()
            .toUri()

        val req = FirmBankingChargeReqDTO(amount.toDouble())

        try {
            val mapper = ObjectMapper()
            val result = client.sendPostRequest(uri, 55, mapper.writeValueAsString(req))
            return ObjectMapper().readValue(result.body(), FirmBankingChargeResDTO::class.java)
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }
}
package org.fcpay.common

import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Component
class CommonHttpClient(
    private val client: HttpClient = HttpClient.newBuilder().build()
) {
    fun sendPostRequest(uri: URI, userId: Long, body: String): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-Type", "application/json")
            .header("X-TEMP-USER-ID", userId.toString())
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build()

        return client.send(request, HttpResponse.BodyHandlers.ofString())
    }
}
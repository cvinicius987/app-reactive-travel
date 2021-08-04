package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.destiny.DestinyGateway
import br.com.cvinicius.agency.core.dataprovider.destiny.DestinyResponse
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import java.math.BigDecimal
import java.util.*

@WebFluxTest(DestinyApi::class)
internal class DestinyApiTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var destinyGateway: DestinyGateway

    @Test
    fun `Load all Destinys`(){

        val response = arrayOf(DestinyResponse(UUID.randomUUID(), "Porto Seguro", BigDecimal.valueOf(120.55), "BA", "Praia"),
                                DestinyResponse(UUID.randomUUID(), "Maceio", BigDecimal.valueOf(144.48), "AL", "Mergulho"))

        Mockito.`when`(destinyGateway.findAll()).thenReturn(Flux.fromArray(response))

        webTestClient.get()
                .uri("/destiny")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBodyList(DestinyResponse::class.java)

        Mockito.verify(destinyGateway).findAll()
    }

    @Test
    fun `Load all Destinys but result is empty`(){

        Mockito.`when`(destinyGateway.findAll()).thenReturn(Flux.empty())

        webTestClient.get()
                .uri("/destiny")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("[]")

        Mockito.verify(destinyGateway).findAll()
    }
}
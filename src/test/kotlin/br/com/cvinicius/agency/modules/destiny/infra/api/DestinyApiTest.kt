package br.com.cvinicius.agency.modules.destiny.infra.api

import br.com.cvinicius.agency.modules.destiny.application.query.DestinyQuery
import br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse
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

@WebFluxTest(br.com.cvinicius.agency.modules.destiny.infra.api.DestinyApi::class)
internal class DestinyApiTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var destinyQuery: br.com.cvinicius.agency.modules.destiny.application.query.DestinyQuery

    @Test
    fun `Load all Destinys`(){

        val response = arrayOf(
            br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse(
                UUID.randomUUID(),
                "Porto Seguro",
                BigDecimal.valueOf(120.55),
                "BA",
                "Praia"
            ),
            br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse(
                UUID.randomUUID(),
                "Maceio",
                BigDecimal.valueOf(144.48),
                "AL",
                "Mergulho"
            )
        )

        Mockito.`when`(destinyQuery.findAll()).thenReturn(Flux.fromArray(response))

        webTestClient.get()
                .uri("/destiny")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBodyList(br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse::class.java)

        Mockito.verify(destinyQuery).findAll()
    }

    @Test
    fun `Load all Destinys but result is empty`(){

        Mockito.`when`(destinyQuery.findAll()).thenReturn(Flux.empty())

        webTestClient.get()
                .uri("/destiny")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("[]")

        Mockito.verify(destinyQuery).findAll()
    }
}
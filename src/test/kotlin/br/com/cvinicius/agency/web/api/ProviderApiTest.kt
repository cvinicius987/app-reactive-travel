package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.provider.ProviderGateway
import br.com.cvinicius.agency.core.dataprovider.provider.ProviderResponse
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import java.util.*

@WebFluxTest(ProviderApi::class)
internal class ProviderApiTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var providerGateway: ProviderGateway

    @Test
    fun `Load all Providers`(){

        val response = arrayOf(ProviderResponse(UUID.randomUUID(), "Turismo SP"),
                                ProviderResponse(UUID.randomUUID(), "Agência Vamos Nessa S/A"))

        `when`(providerGateway.findAll()).thenReturn(Flux.fromArray(response))

        webTestClient.get()
                .uri("/provider")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBodyList(ProviderResponse::class.java)

        verify(providerGateway).findAll()
    }

    @Test
    fun `Load all Providers but result is empty`(){

        `when`(providerGateway.findAll()).thenReturn(Flux.empty())

        webTestClient.get()
                .uri("/provider")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("[]")

        verify(providerGateway).findAll()
    }
}
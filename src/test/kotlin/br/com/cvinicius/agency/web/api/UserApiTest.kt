package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.user.UserGateway
import br.com.cvinicius.agency.core.dataprovider.user.UserResponse
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

@WebFluxTest(UserApi::class)
class UserApiTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var userGateway: UserGateway

    @Test
    fun `Load all Users`(){

        val response = arrayOf(UserResponse(UUID.randomUUID(), "João"),
                                UserResponse(UUID.randomUUID(), "Leticia"))

        `when`(userGateway.findAll()).thenReturn(Flux.fromArray(response))

        webTestClient.get()
                .uri("/user")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBodyList(UserResponse::class.java)

        verify(userGateway).findAll()
    }

    @Test
    fun `Load all User but result is empty`(){

        `when`(userGateway.findAll()).thenReturn(Flux.empty())

        webTestClient.get()
                .uri("/user")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("[]")

        verify(userGateway).findAll()
    }
}
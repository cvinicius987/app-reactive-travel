package br.com.cvinicius.agency.application.api.deposit

import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.util.*

/*
@WebFluxTest(DepositApi::class)
class DepositApiTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var generateDepositUsecase: GenerateDepositUsecase

    @Test
    fun generate_new_deposit_transaction(){

        val dto = DepositDto("25365555548994654564654564132",
                                    UUID.fromString("39c5859c-e26c-4c2d-bd75-a1ae5868f124"),
                                    BigDecimal.valueOf(100.55))

        given(generateDepositUsecase.execute(dto.to())).willReturn(Mono.empty())

        webTestClient.post()
                .uri("/deposits")
                    .body(BodyInserters.fromValue(dto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated
                .expectBody()
    }

    @Test
    fun new_deposit_invalid_parameters_test(){

        val dto = DepositDto("25365555548994654564654564132",
                            UUID.fromString("39c5859c-e26c-4c2d-bd75-a1ae5868f124"))

        webTestClient.post()
                .uri("/deposits")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isBadRequest
                .expectBody()
    }

    /*
    @Test
    fun new_deposit_rabbit_unnavailable_test(){

        val dto = DepositDto("25365555548994654564654564132",
                            UUID.fromString("39c5859c-e26c-4c2d-bd75-a1ae5868f124"),
                            BigDecimal.valueOf(100.55))

        given(generateDepositUsecase.execute(dto.to())).willThrow(AmqpConnectException::class.java)

        webTestClient.post()
                        .uri("/deposits")
                        .accept(MediaType.APPLICATION_JSON)
                    .exchange()
                        .expectStatus().isBadRequest
                        .expectBody()
                        .jsonPath("timestamp").isNotEmpty
    }

     */
}

 */
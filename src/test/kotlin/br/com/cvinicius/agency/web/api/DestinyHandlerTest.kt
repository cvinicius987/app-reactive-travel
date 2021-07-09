package br.com.cvinicius.agency.web.api

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DestinyApiTest {

    val BASE_URL = "http://localhost:8080"

    @Autowired
    lateinit var webClient: WebClient

    @BeforeEach
    fun setUp() {
        webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(ReactorClientHttpConnector(HttpClient.create().wiretap(true)))
                .build()
    }

    @Test
    fun when_load_all_destiny(){

    }
}
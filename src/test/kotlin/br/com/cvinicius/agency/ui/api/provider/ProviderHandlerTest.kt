package br.com.cvinicius.agency.ui.api.provider

/*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.kotlin.core.publisher.toFlux
import java.util.*


@WebFluxTest(AccountApi::class)
class AccountApiTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var accountRepository: AccountRepository

    private lateinit var accounts:List<Account>

    @BeforeEach
    fun prepare(){

        accounts = listOf(Account(UUID.randomUUID(), "0001","Maria"),
                          Account(UUID.randomUUID(), "0002", "Joao"))
    }

    @Test
    fun when_load_all_accounts(){

        given(accountRepository.findAll(Sort.by("code"))).willReturn(accounts.toFlux())

        webTestClient.get()
                .uri("/accounts")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody(List::class.java)
    }
}

 */
package br.com.cvinicius.agency.application.api.transaction

/*
import br.com.cvinicius.agency.core.domain.transaction.Transaction
import br.com.cvinicius.agency.core.domain.transaction.TransactionRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.kotlin.core.publisher.toFlux
import java.math.BigDecimal
import java.util.*

@WebFluxTest(TransactionApi::class)
class TransactionApiTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var transactionRepository: TransactionRepository

    private lateinit var accountId:UUID
    private lateinit var list:List<Transaction>

    @BeforeEach
    fun prepare(){

        accountId = UUID.randomUUID()

        list = listOf(Transaction.newDeposit(BigDecimal.valueOf(100.55), accountId),
                      Transaction.newTransfer(BigDecimal.valueOf(10.00), accountId),
                      Transaction.newDebit(BigDecimal.valueOf(20.83), accountId))
    }

    @Test
    fun list_transactions_byAcoountId(){

        given(transactionRepository.findByAccountId(accountId)).willReturn(list.toFlux())

        webTestClient.get()
                .uri("/$accountId/transactions")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody(List::class.java)
    }
}

 */
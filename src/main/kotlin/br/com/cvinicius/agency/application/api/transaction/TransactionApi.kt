package br.com.cvinicius.agency.application.api.transaction

import br.com.cvinicius.agency.core.domain.transaction.Transaction
import br.com.cvinicius.agency.core.domain.transaction.TransactionRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.*

@RestController
class TransactionApi(private val transactionRepository: TransactionRepository) {

    @GetMapping("{accountId}/transactions")
    fun listByAccountId(@PathVariable accountId:UUID): Flux<Transaction>{

        return transactionRepository.findByAccountId(accountId)
    }
}
package br.com.cvinicius.agency.core.domain.transaction

import br.com.cvinicius.agency.core.domain.transaction.card.CreditCard
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface TransactionRepository {

    fun save(transaction:Transaction):Mono<Transaction>

    fun save(transaction:Transaction, creditCard: CreditCard):Mono<Transaction>

    fun saveLog(transactionLog: TransactionLog): Mono<TransactionLog>

    fun updateStatus(transactionId:UUID, status: TransactionStatus):Mono<Void>

    fun findById(id:UUID): Mono<Transaction>

    fun findByAccountId(accountId:UUID): Flux<Transaction>
}
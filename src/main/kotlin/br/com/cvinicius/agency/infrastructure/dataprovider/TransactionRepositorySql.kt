package br.com.cvinicius.agency.infrastructure.dataprovider

import br.com.cvinicius.agency.core.domain.transaction.Transaction
import br.com.cvinicius.agency.core.domain.transaction.TransactionLog
import br.com.cvinicius.agency.core.domain.transaction.TransactionRepository
import br.com.cvinicius.agency.core.domain.transaction.TransactionStatus
import br.com.cvinicius.agency.core.domain.transaction.card.CreditCard
import br.com.cvinicius.agency.core.domain.transaction.card.TransactionCard
import org.springframework.data.domain.Sort.Order.desc
import org.springframework.data.domain.Sort.by
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.Criteria.where
import org.springframework.data.relational.core.query.Query
import org.springframework.data.relational.core.query.Query.query
import org.springframework.data.relational.core.query.Update
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Repository
internal class TransactionRepositorySql(private val template: R2dbcEntityTemplate) : TransactionRepository {

    @Transactional
    override fun save(transaction: Transaction): Mono<Transaction> {

       return template.insert(Transaction::class.java)
                        .using(transaction)
    }

    @Transactional
    override fun save(transaction: Transaction, creditCard: CreditCard): Mono<Transaction> {

        return save(transaction).doOnNext {

            template.insert(TransactionCard::class.java)
                    .using(TransactionCard(it.transactionId, creditCard.number))
            it
        }
    }

    @Transactional
    override fun saveLog(transactionLog: TransactionLog): Mono<TransactionLog> {

        return template.insert(TransactionLog::class.java)
                .using(transactionLog)
    }

    @Transactional
    override fun updateStatus(transactionId:UUID, status: TransactionStatus): Mono<Void> {

        return template.update(Transaction::class.java)
                        .inTable("tbl_transaction")
                        .matching(Query.query(Criteria.where("id").`is`(transactionId)))
                        .apply(Update.update("status", status))
                        .then()
    }

    override fun findById(id: UUID): Mono<Transaction> {

        return template.select(Transaction::class.java)
                        .from("tbl_transaction")
                        .matching(Query.query(Criteria.where("id").`is`(id)))
                        .one()
    }

    override fun findByAccountId(accountId: UUID): Flux<Transaction> {

        return template.select(Transaction::class.java)
                        .from("tbl_transaction")
                        .matching(query(where("account_id").`is`(accountId))
                                .sort(by(desc("datetime"))))
                        .all()
    }
}
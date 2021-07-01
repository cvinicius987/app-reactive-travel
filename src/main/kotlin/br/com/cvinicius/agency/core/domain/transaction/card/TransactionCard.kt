package br.com.cvinicius.agency.core.domain.transaction.card

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

import java.util.*

@Table(value = "tbl_transaction_card")
class TransactionCard(
        @Id
       val transactionId:UUID,
       val number:String
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionCard

        if (transactionId != other.transactionId) return false

        return true
    }

    override fun hashCode() = transactionId.hashCode()
}
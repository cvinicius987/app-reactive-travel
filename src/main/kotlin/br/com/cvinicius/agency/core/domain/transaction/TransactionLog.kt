package br.com.cvinicius.agency.core.domain.transaction

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

import java.util.*

@Table(value = "tbl_transaction_log")
class TransactionLog(
       @Id
       val id:UUID,
       val datetime:LocalDateTime,
       val msg:String,
       val transactionId:UUID,
       val gatewayTransId:String?
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionLog

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}
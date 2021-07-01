package br.com.cvinicius.agency.core.domain.wallet

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

import java.time.LocalDateTime
import java.util.*

@Table(value = "tbl_wallet")
class Wallet(
       @Id
       val id:UUID,
       @Column(value="transaction_id")
       val transactionId:UUID,
       val datetime:LocalDateTime
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Wallet

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}
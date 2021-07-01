package br.com.cvinicius.agency.core.domain.wallet

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Table(value = "tbl_wallet_resume")
class WalletResume(
        @Id
        val userId:UUID,

        val value:BigDecimal,

        @Column(value="last_update")
        val lastUpdate:LocalDateTime
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WalletResume

        if (userId != other.userId) return false

        return true
    }

    override fun hashCode() = userId.hashCode()
}
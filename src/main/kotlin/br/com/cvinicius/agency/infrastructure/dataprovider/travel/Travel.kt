package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Table(value = "tbl_travel")
class Travel(
        @Id
        val id:UUID,

        val datetime:LocalDateTime,

        val value:BigDecimal,

        val userId:Long,

        val destinyId:Long,

        val providerId:Long){

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Travel

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return id.hashCode()
        }
}

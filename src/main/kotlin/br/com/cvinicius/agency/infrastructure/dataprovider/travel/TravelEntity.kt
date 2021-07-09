package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Table(value = "tbl_travel")
data class TravelEntity(
        @Id
        val id:UUID,

        val datetime:LocalDateTime,

        val userId:UUID,

        val destinyId:UUID,

        val providerId:UUID)


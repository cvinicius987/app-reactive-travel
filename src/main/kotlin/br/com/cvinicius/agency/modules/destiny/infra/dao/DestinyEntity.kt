package br.com.cvinicius.agency.modules.destiny.infra.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.util.*

@Table(value = "tbl_destiny")
class DestinyEntity(
        @Id
        val id:UUID,

        val name:String,

        val value: BigDecimal,

        val state:String,

        val description:String?)
package br.com.cvinicius.agency.infrastructure.dataprovider.provider

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(value = "tbl_provider")
class ProviderEntity(
        @Id
        val id: UUID,

        val name:String)
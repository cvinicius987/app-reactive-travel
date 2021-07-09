package br.com.cvinicius.agency.infrastructure.dataprovider.provider

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(value = "tbl_provider")
class ProviderEntity(
        @Id
        val id: UUID,

        val name:String){

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as ProviderEntity

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return id.hashCode()
        }
}

package br.com.cvinicius.agency.infrastructure.dataprovider.destiny

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "tbl_destiny")
class DestinyEntity(
        @Id
        val id:Long,

        val name:String,

        val state:String,

        val description:String?){

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as DestinyEntity

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return id.hashCode()
        }
}

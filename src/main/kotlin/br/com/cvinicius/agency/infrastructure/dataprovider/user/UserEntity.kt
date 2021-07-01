package br.com.cvinicius.agency.infrastructure.dataprovider.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "tbl_user")
class UserEntity(
        @Id
        val id:Long,

        val name:String){

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as UserEntity

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return id.hashCode()
        }
}

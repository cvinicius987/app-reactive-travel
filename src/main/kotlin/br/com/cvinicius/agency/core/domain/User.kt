package br.com.cvinicius.agency.core.domain

import br.com.cvinicius.agency.infrastructure.dataprovider.user.UserEntity

class User(val id:Long,
           val name:String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}


package br.com.cvinicius.agency.core.domain

import br.com.cvinicius.agency.infrastructure.dataprovider.travel.TravelEntity
import java.time.LocalDateTime
import java.util.*

class Travel(
        val id:UUID,
        val datetime:LocalDateTime,
        val qtd:Int,
        val userId:UUID,
        val destinyId:UUID,
        val providerId:UUID){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TravelEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

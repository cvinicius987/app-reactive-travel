package br.com.cvinicius.agency.core.domain

import java.math.BigDecimal
import java.util.*

class Destiny(
        val id: UUID,
        val name:String,
        val value: BigDecimal,
        val state:String,
        val description:String?){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Destiny

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
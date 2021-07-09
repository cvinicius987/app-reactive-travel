package br.com.cvinicius.agency.core.domain

import java.math.BigDecimal

class Destiny(
        val id:Long,
        val name:String,
        val value: BigDecimal,
        val state:String,
        val description:String?)
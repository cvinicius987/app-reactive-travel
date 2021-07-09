package br.com.cvinicius.agency.service.destiny

import java.math.BigDecimal

data class DestinyResponse(val id:Long,
                           val name:String,
                           val value:BigDecimal,
                           val state:String,
                           val description:String?)
package br.com.cvinicius.agency.service.destiny

import java.math.BigDecimal
import java.util.*

data class DestinyResponse(val id:UUID,
                           val name:String,
                           val value:BigDecimal,
                           val state:String,
                           val description:String?)
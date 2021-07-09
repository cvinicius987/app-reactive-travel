package br.com.cvinicius.agency.service.travel

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class TravelResponse(val id: UUID,
                          val datetime:LocalDateTime,
                          val qtd:Int,
                          val unitValue: BigDecimal,
                          val destiny:String,
                          val provider:String,
                          val user:String)
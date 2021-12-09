package br.com.cvinicius.agency.modules.travel.application.response

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class TravelResponse(val id: UUID,
                          val datetime:LocalDateTime,
                          val qtd:Int,
                          val destiny:UUID,
                          val provider:UUID,
                          val user:UUID,
                          val totalValue: BigDecimal)
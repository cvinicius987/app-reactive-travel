package br.com.cvinicius.agency.service.travel

import java.time.LocalDateTime
import java.util.*

data class TravelResponse(val id: UUID,
                          val datetime:LocalDateTime,
                          val destiny:String,
                          val provider:String,
                          val user:String)
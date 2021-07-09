package br.com.cvinicius.agency.service.travel

import java.time.LocalDateTime

data class TravelResponse(val id:Long,
                          val datetime:LocalDateTime,
                          val destiny:String,
                          val provider:String,
                          val user:String)
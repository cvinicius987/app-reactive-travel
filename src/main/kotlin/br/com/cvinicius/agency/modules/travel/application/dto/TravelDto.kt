package br.com.cvinicius.agency.modules.travel.application.dto

import br.com.cvinicius.agency.modules.travel.application.usecase.NewTravel
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.NotNull

fun TravelDto.toTravel() = NewTravel(datetime!!, qtd!!, userId!!, providerId!!, destinyId!!)

class TravelDto(

        @NotNull
        var datetime:LocalDateTime? = null,

        @NotNull
        var qtd:Int? = null,

        @NotNull
        var userId:UUID? = null,

        @NotNull
        var providerId:UUID? = null,

        @NotNull
        var destinyId:UUID? = null){

        override fun toString() = "TravelDto(datetime=$datetime, qtd=$qtd, userId=$userId, providerId=$providerId, destinyId=$destinyId)"
}
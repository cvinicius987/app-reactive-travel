package br.com.cvinicius.agency.web.dto

import br.com.cvinicius.agency.core.usecase.NewTravel
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull

fun TravelDto.to() = NewTravel(datetime, userId, providerId, destinyId)

class TravelDto {

    @NotNull
    lateinit var userId:UUID

    @NotNull
    lateinit var providerId:UUID

    @NotNull
    lateinit var destinyId:UUID

    @NotNull
    @Future
    lateinit var datetime:LocalDateTime
}
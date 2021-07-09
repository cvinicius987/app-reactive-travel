package br.com.cvinicius.agency.core.usecase

import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

data class NewTravel(val datetime:LocalDateTime,
                     val qtd:Int,
                     val userId:UUID,
                     val providerId:UUID,
                     val destinyId:UUID)

interface GenarateTravelUsecase {

    fun generate(newTravel:NewTravel): Mono<UUID>
}
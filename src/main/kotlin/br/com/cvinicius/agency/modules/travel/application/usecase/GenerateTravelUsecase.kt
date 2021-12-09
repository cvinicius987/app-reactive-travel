package br.com.cvinicius.agency.modules.travel.application.usecase

import reactor.core.publisher.Mono
import java.util.*

interface GenarateTravelUsecase {

    fun execute(newTravel: NewTravel): Mono<UUID>
}
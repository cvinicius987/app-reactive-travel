package br.com.cvinicius.agency.modules.travel.application.query

import br.com.cvinicius.agency.modules.travel.application.response.TravelResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface TravelQuery {

    fun findAll(): Flux<TravelResponse>

    fun findById(id: UUID): Mono<TravelResponse>
}
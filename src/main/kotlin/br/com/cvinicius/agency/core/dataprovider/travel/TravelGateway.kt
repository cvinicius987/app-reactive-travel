package br.com.cvinicius.agency.core.dataprovider.travel

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface TravelGateway {

    fun findAll(): Flux<TravelResponse>

    fun findById(id: UUID): Mono<TravelResponse>
}
package br.com.cvinicius.agency.modules.travel.domain

import reactor.core.publisher.Mono

interface TravelRepository {

    fun save(travel: Travel): Mono<Travel>
}
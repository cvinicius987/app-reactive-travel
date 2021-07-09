package br.com.cvinicius.agency.core.domain

import reactor.core.publisher.Mono

interface TravelRepository {

    fun save(travel:Travel): Mono<Travel>
}
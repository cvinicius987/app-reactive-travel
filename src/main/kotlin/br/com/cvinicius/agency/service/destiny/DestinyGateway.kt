package br.com.cvinicius.agency.service.destiny

import reactor.core.publisher.Flux

interface DestinyGateway {

    fun findAll(): Flux<DestinyResponse>
}
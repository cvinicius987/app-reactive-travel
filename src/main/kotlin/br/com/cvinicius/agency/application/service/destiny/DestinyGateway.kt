package br.com.cvinicius.agency.application.service.destiny

import reactor.core.publisher.Flux

interface DestinyGateway {

    fun findAll(): Flux<DestinyResponse>
}
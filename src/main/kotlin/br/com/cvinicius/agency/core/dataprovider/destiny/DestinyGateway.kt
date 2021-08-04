package br.com.cvinicius.agency.core.dataprovider.destiny

import reactor.core.publisher.Flux

interface DestinyGateway {

    fun findAll(): Flux<DestinyResponse>
}
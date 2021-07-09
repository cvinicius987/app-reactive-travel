package br.com.cvinicius.agency.service.destiny

import br.com.cvinicius.agency.service.destiny.DestinyResponse
import reactor.core.publisher.Flux

interface DestinyGateway {

    fun findAll(): Flux<DestinyResponse>
}
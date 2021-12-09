package br.com.cvinicius.agency.modules.destiny.application.query

import br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse
import reactor.core.publisher.Flux

interface DestinyQuery {

    fun findAll(): Flux<DestinyResponse>
}
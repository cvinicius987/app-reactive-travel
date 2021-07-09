package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import br.com.cvinicius.agency.service.travel.TravelGateway
import br.com.cvinicius.agency.service.travel.TravelResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Repository
internal class TravelGatewaySql(private val template: R2dbcEntityTemplate) : TravelGateway {

    override fun findAll(): Flux<TravelResponse> {

        return Flux.empty()
    }

    override fun findById(id: UUID): Mono<TravelResponse> {
        TODO("Not yet implemented")
    }
}
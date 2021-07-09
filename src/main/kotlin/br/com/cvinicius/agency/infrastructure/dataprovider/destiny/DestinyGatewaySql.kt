package br.com.cvinicius.agency.infrastructure.dataprovider.destiny

import br.com.cvinicius.agency.service.destiny.DestinyGateway
import br.com.cvinicius.agency.service.destiny.DestinyResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class DestinyGatewaySql(private val template: R2dbcEntityTemplate) : DestinyGateway {

    override fun findAll(): Flux<DestinyResponse> {

        return template.select(DestinyEntity::class.java)
                        .from("tbl_destiny")
                        .all()
                        .map { DestinyResponse(it.id, it.name, it.value, it.state, it.description) }
    }
}
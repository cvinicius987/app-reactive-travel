package br.com.cvinicius.agency.modules.destiny.infra.dao

import br.com.cvinicius.agency.modules.destiny.application.query.DestinyQuery
import br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class DestinyRepositorySql(private val template: R2dbcEntityTemplate) : DestinyQuery {

    fun DestinyEntity.toResponse() = DestinyResponse(
            id,
            name,
            value,
            state,
            description
        )

    override fun findAll(): Flux<DestinyResponse> {

        return template.select(DestinyEntity::class.java)
                        .from("tbl_destiny")
                        .all()
                        .map { it.toResponse() }
    }
}
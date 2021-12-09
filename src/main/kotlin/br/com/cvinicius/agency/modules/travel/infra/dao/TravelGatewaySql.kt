package br.com.cvinicius.agency.modules.travel.infra.dao

import br.com.cvinicius.agency.modules.travel.domain.Travel
import br.com.cvinicius.agency.modules.travel.domain.TravelRepository
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Repository
internal class TravelRespositorySql(private val template: R2dbcEntityTemplate,
                                private val databaseClient: DatabaseClient) : TravelRepository {

    fun Travel.toEntity() = TravelEntity(id, datetime, qtd, userId, destinyId, providerId)

    fun TravelEntity.toDomain() = Travel(id, datetime, qtd, userId, destinyId, providerId)

    @Transactional
    override fun save(travel: Travel):Mono<Travel> {

        return template.insert(TravelEntity::class.java)
                .using(travel.toEntity())
                .map { it.toDomain() }
    }
}
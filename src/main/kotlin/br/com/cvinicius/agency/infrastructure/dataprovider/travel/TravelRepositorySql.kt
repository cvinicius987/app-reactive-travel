package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import br.com.cvinicius.agency.core.domain.Travel
import br.com.cvinicius.agency.core.domain.TravelRepository
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Repository
internal class TravelRepositorySql(private val template: R2dbcEntityTemplate) : TravelRepository {

    @Transactional
    override fun save(travel: Travel):Mono<Travel> {

        val travelEntity = travel.run {
            TravelEntity(id, datetime, userId, destinyId, providerId)
        }

        return template.insert(TravelEntity::class.java)
                       .using(travelEntity)
                       .map { Travel(it.id, it.datetime, it.userId, it.destinyId, it.providerId) }
    }
}
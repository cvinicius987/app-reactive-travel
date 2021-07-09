package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import br.com.cvinicius.agency.core.domain.Travel
import br.com.cvinicius.agency.core.domain.TravelRepository
import br.com.cvinicius.agency.service.travel.TravelGateway
import br.com.cvinicius.agency.service.travel.TravelResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Repository
internal class TravelRepositorySql(private val template: R2dbcEntityTemplate) : TravelRepository {

    @Transactional
    override fun save(travel: Travel) {

    }
}
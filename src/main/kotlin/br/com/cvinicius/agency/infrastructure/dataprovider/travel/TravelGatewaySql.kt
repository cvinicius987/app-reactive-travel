package br.com.cvinicius.agency.infrastructure.dataprovider.travel

import br.com.cvinicius.agency.service.travel.TravelGateway
import br.com.cvinicius.agency.service.travel.TravelResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Repository
internal class TravelGatewaySql(private val template: R2dbcEntityTemplate,
                                private val databaseClient: DatabaseClient) : TravelGateway {

    override fun findAll(): Flux<TravelResponse> {

        val sql = """
            SELECT
                t.id, 
                t.datetime, 
                t.qtd, 
                d.value as unitValue,   
                d.name as destiny, 
                p.name as provider, 
                u.name as username
            FROM tbl_travel t
                INNER JOIN tbl_destiny d
                    ON d.id = t.destiny_id
                INNER JOIN tbl_provider p
                    ON p.id = t.provider_id
                INNER JOIN tbl_user u
                    ON u.id = t.user_id
            ORDER BY
                t.datetime
        """

        return databaseClient.sql(sql)
                      .fetch()
                      .all()
                      .map {
                          TravelResponse(UUID.fromString(it["id"] as String),
                                         LocalDateTime.now(),
                                         Integer.valueOf(it["qtd"] as String),
                                         BigDecimal.ZERO,
                                         UUID.fromString(it["destiny"] as String),
                                          UUID.fromString(it["provider"] as String),
                                          UUID.fromString(it["username"] as String)) }
    }

    override fun findById(id: UUID): Mono<TravelResponse> {
        TODO("Not yet implemented")
    }
}
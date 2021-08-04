package br.com.cvinicius.agency.infrastructure.dataprovider.provider

import br.com.cvinicius.agency.core.dataprovider.provider.ProviderGateway
import br.com.cvinicius.agency.core.dataprovider.provider.ProviderResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class ProviderGatewaySql(private val template: R2dbcEntityTemplate) : ProviderGateway {

    override fun findAll(): Flux<ProviderResponse> {

        return template.select(ProviderEntity::class.java)
                        .from("tbl_provider")
                        .all()
                        .map { ProviderResponse(it.id, it.name) }
    }
}
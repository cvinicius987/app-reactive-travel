package br.com.cvinicius.agency.modules.provider.infra.dao

import br.com.cvinicius.agency.modules.provider.application.query.ProviderQuery
import br.com.cvinicius.agency.modules.provider.application.response.ProviderResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class ProviderDao(private val template: R2dbcEntityTemplate) : ProviderQuery {

    fun ProviderEntity.toResponse() = ProviderResponse(id, name)

    override fun findAll(): Flux<ProviderResponse> {

        return template.select(ProviderEntity::class.java)
                        .from("tbl_provider")
                        .all()
                        .map { it.toResponse() }
    }
}
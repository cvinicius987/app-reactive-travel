package br.com.cvinicius.agency.modules.provider.application.query

import br.com.cvinicius.agency.modules.provider.application.response.ProviderResponse
import reactor.core.publisher.Flux

interface ProviderQuery {

    fun findAll(): Flux<ProviderResponse>
}
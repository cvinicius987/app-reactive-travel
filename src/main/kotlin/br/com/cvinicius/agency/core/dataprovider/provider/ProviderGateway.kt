package br.com.cvinicius.agency.core.dataprovider.provider

import reactor.core.publisher.Flux

interface ProviderGateway {

    fun findAll(): Flux<ProviderResponse>
}
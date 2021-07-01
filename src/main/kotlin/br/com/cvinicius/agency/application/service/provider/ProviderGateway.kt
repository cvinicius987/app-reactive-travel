package br.com.cvinicius.agency.application.service.provider

import reactor.core.publisher.Flux

interface ProviderGateway {

    fun findAll(): Flux<ProviderResponse>
}
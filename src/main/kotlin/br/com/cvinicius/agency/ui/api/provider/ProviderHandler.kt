package br.com.cvinicius.agency.ui.api.provider

import br.com.cvinicius.agency.application.service.provider.ProviderGateway
import br.com.cvinicius.agency.application.service.provider.ProviderResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ProviderHandler(private val providerGateway: ProviderGateway) {

    fun getAll(request: ServerRequest): Mono<ServerResponse> {

        return ServerResponse.ok().body(providerGateway.findAll(), ProviderResponse::class.java)
    }
}
package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.service.provider.ProviderGateway
import br.com.cvinicius.agency.service.provider.ProviderResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ProviderApi(private val providerGateway: ProviderGateway) {

    @GetMapping("/provider")
    fun getAll(): ResponseEntity<Flux<ProviderResponse>> {

        val all = providerGateway.findAll()

        return ResponseEntity.ok(all)
    }
}
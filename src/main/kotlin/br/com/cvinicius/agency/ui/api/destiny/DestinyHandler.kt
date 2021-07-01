package br.com.cvinicius.agency.ui.api.destiny

import br.com.cvinicius.agency.application.service.destiny.DestinyGateway
import br.com.cvinicius.agency.application.service.destiny.DestinyResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class DestinyHandler(private val destinyGateway: DestinyGateway) {

    fun getAll(request: ServerRequest): Mono<ServerResponse> {

        return ServerResponse.ok().body(destinyGateway.findAll(), DestinyResponse::class.java)
    }
}
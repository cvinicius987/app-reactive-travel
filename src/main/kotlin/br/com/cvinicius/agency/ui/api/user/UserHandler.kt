package br.com.cvinicius.agency.ui.api.user

import br.com.cvinicius.agency.application.service.user.UserGateway
import br.com.cvinicius.agency.application.service.user.UserResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler(private val userGateway: UserGateway) {

    fun getAll(request: ServerRequest): Mono<ServerResponse> {

        return ServerResponse.ok().body(userGateway.findAll(), UserResponse::class.java)
    }
}
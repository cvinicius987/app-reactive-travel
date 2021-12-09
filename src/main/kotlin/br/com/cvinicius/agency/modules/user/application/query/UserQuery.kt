package br.com.cvinicius.agency.modules.user.application.query

import br.com.cvinicius.agency.modules.user.application.response.UserResponse
import reactor.core.publisher.Flux

interface UserQuery {

    fun findAll(): Flux<UserResponse>
}
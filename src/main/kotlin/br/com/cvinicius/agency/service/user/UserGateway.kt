package br.com.cvinicius.agency.service.user

import reactor.core.publisher.Flux

interface UserGateway {

    fun findAll(): Flux<UserResponse>
}
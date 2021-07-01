package br.com.cvinicius.agency.application.service.user

import reactor.core.publisher.Flux

interface UserGateway {

    fun findAll(): Flux<UserResponse>
}
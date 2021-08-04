package br.com.cvinicius.agency.core.dataprovider.user

import reactor.core.publisher.Flux

interface UserGateway {

    fun findAll(): Flux<UserResponse>
}
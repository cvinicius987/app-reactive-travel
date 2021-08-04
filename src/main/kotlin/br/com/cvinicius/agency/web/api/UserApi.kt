package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.user.UserGateway
import br.com.cvinicius.agency.core.dataprovider.user.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class UserApi(private val userGateway: UserGateway) {

    @GetMapping("/user")
    fun getAll():ResponseEntity<Flux<UserResponse>>{

        val all = userGateway.findAll()

        return ResponseEntity.ok(all)
    }
}
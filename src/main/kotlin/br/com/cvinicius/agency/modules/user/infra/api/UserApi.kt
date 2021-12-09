package br.com.cvinicius.agency.modules.user.infra.api

import br.com.cvinicius.agency.modules.user.application.query.UserQuery
import br.com.cvinicius.agency.modules.user.application.response.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class UserApi(private val userQuery: UserQuery) {

    @GetMapping("/user")
    fun getAll():ResponseEntity<Flux<UserResponse>>{

        val all = userQuery.findAll()

        return ResponseEntity.ok(all)
    }
}
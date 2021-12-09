package br.com.cvinicius.agency.modules.destiny.infra.api

import br.com.cvinicius.agency.modules.destiny.application.query.DestinyQuery
import br.com.cvinicius.agency.modules.destiny.application.response.DestinyResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class DestinyApi(private val destinyQuery: DestinyQuery) {

    @GetMapping("/destiny")
    fun getAll(): ResponseEntity<Flux<DestinyResponse>> {

        val all = destinyQuery.findAll()

        return ResponseEntity.ok(all)
    }
}
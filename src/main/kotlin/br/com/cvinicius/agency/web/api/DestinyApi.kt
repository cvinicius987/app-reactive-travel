package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.destiny.DestinyGateway
import br.com.cvinicius.agency.core.dataprovider.destiny.DestinyResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class DestinyApi(private val destinyGateway: DestinyGateway) {

    @GetMapping("/destiny")
    fun getAll(): ResponseEntity<Flux<DestinyResponse>> {

        val all = destinyGateway.findAll()

        return ResponseEntity.ok(all)
    }
}
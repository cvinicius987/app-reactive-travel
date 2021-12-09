package br.com.cvinicius.agency.modules.provider.infra.api

import br.com.cvinicius.agency.modules.provider.application.query.ProviderQuery
import br.com.cvinicius.agency.modules.provider.application.response.ProviderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ProviderApi(private val providerQuery: ProviderQuery) {

    @GetMapping("/provider")
    fun getAll(): ResponseEntity<Flux<ProviderResponse>> {

        val all = providerQuery.findAll()

        return ResponseEntity.ok(all)
    }
}
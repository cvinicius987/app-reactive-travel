package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.dataprovider.provider.ProviderGateway
import br.com.cvinicius.agency.core.dataprovider.provider.ProviderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ProviderApi(private val providerGateway: ProviderGateway) {

    @GetMapping("/provider")
    fun getAll(): ResponseEntity<Flux<ProviderResponse>> {

        val all = providerGateway.findAll()

        return ResponseEntity.ok(all)
    }
}
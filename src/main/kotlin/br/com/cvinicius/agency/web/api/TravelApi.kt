package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.usecase.GenarateTravelUsecase
import br.com.cvinicius.agency.core.dataprovider.travel.TravelGateway
import br.com.cvinicius.agency.core.dataprovider.travel.TravelResponse
import br.com.cvinicius.agency.web.dto.TravelDto
import br.com.cvinicius.agency.web.dto.toTravel
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.atomic.AtomicReference

@RestController
class TravelApi(private val travelGateway: TravelGateway,
                private val genarateTravelUsecase: GenarateTravelUsecase) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/travel")
    fun getAll():ResponseEntity<Flux<TravelResponse>>{

        val all = travelGateway.findAll()

        return ResponseEntity.ok(all)
    }

    @GetMapping("/travel/{id}")
    fun findBy(@PathVariable("id") id:UUID):ResponseEntity<Mono<TravelResponse>>{

        return ResponseEntity.ok(travelGateway.findById(id))
    }

    @DeleteMapping("/travel/{id}")
    fun delete(@PathVariable("id") id:UUID):ResponseEntity<Void>{

        return ResponseEntity.status(HttpStatus.ACCEPTED).build()
    }

    @PostMapping(value=["/travel"], consumes=[MediaType.APPLICATION_JSON_VALUE])
    fun save(@Validated @RequestBody travelDto: TravelDto):ResponseEntity<Void>{

        logger.info("Registro de nova Travel: $travelDto")

        val result = AtomicReference<UUID>()

        genarateTravelUsecase.generate(travelDto.toTravel())
                             .subscribe { result.set(it) }

        return ResponseEntity
                .created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080/travel/${result.get()}")
                        .build().toUri())
                .build()
    }
}
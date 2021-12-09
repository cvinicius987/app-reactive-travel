package br.com.cvinicius.agency.modules.travel.infra.api

import br.com.cvinicius.agency.modules.travel.application.dto.TravelDto
import br.com.cvinicius.agency.modules.travel.application.dto.toTravel
import br.com.cvinicius.agency.modules.travel.application.query.TravelQuery
import br.com.cvinicius.agency.modules.travel.application.usecase.GenarateTravelUsecase
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import java.util.concurrent.atomic.AtomicReference

@RestController
class TravelApi(private val travelQuery: TravelQuery,
                private val genarateTravelUsecase: GenarateTravelUsecase
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/travel")
    fun getAll() = ResponseEntity.ok(travelQuery.findAll())

    @GetMapping("/travel/{id}")
    fun findBy(@PathVariable("id") id:UUID) = ResponseEntity.ok(travelQuery.findById(id))

    @PostMapping(value=["/travel"], consumes=[MediaType.APPLICATION_JSON_VALUE])
    fun save(@Validated @RequestBody travelDto: TravelDto):ResponseEntity<Void>{

        logger.info("Registro de nova Travel: $travelDto")

        val result = AtomicReference<UUID>()

        genarateTravelUsecase.execute(travelDto.toTravel())
                             .subscribe { result.set(it) }

        return ResponseEntity
                .created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080/travel/${result.get()}")
                        .build().toUri())
                .build()
    }
}
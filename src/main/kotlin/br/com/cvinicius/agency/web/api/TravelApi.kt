package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.usecase.TravelUsecase
import br.com.cvinicius.agency.service.travel.TravelGateway
import br.com.cvinicius.agency.service.travel.TravelResponse
import br.com.cvinicius.agency.web.dto.TravelDto
import br.com.cvinicius.agency.web.dto.to
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import javax.validation.Valid

@RestController
class TravelApi(private val travelGateway: TravelGateway,
                private val travelUsecase: TravelUsecase) {

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

        travelGateway.deleteTravel(id)

        return ResponseEntity.status(HttpStatus.ACCEPTED).build()
    }

    @PostMapping("/travel")
    fun save(@Valid @RequestBody travelDto: TravelDto):ResponseEntity<Void>{

        val result = AtomicReference<UUID>()

        travelUsecase.generateTravel(travelDto.to())
                     .subscribe { result.set(it) }

        return ResponseEntity
                .created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost/travel/${result.get()}")
                        .build().toUri())
                .build()
    }
}
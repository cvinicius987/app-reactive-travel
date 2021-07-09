package br.com.cvinicius.agency.web.api

import br.com.cvinicius.agency.core.usecase.GenarateTravelUsecase
import br.com.cvinicius.agency.service.travel.TravelGateway
import br.com.cvinicius.agency.service.travel.TravelResponse
import br.com.cvinicius.agency.web.dto.TravelDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
class TravelApi(private val travelGateway: TravelGateway,
                private val genarateTravelUsecase: GenarateTravelUsecase) {

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

    @PostMapping("/travel")
    fun save(@RequestBody travelDto: TravelDto):ResponseEntity<Void>{

        println(travelDto)

        /*
        val result = AtomicReference<UUID>()

        genarateTravelUsecase.generate(travelDto.to())
                             .subscribe { result.set(it) }

        return ResponseEntity
                .created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080/travel/${result.get()}")
                        .build().toUri())
                .build()
         */

        return ResponseEntity.ok().build();
    }
}
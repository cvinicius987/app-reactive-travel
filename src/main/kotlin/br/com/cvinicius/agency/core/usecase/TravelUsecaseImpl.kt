package br.com.cvinicius.agency.core.usecase

import br.com.cvinicius.agency.core.domain.TravelRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
internal class TravelUsecaseImpl(private val travelRepository: TravelRepository) : TravelUsecase {

    override fun generateTravel(newTravel: NewTravel): Mono<UUID> {

        return Mono.just(UUID.randomUUID())
    }
}
package br.com.cvinicius.agency.core.usecase

import br.com.cvinicius.agency.core.domain.Travel
import br.com.cvinicius.agency.core.domain.TravelRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
internal class GenerateTravelUsecaseImpl(private val travelRepository: TravelRepository) : GenarateTravelUsecase {

    override fun generate(newTravel: NewTravel): Mono<UUID> {

        return Mono.just(newTravel).map {
            Travel(UUID.randomUUID(), it.datetime, it.userId, it.providerId, it.destinyId)
        }.doOnNext {
            travelRepository.save(it)
        }.map {
            it.id
        }
    }
}
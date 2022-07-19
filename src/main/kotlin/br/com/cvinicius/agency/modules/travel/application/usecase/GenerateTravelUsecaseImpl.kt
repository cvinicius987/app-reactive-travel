package br.com.cvinicius.agency.modules.travel.application.usecase

import br.com.cvinicius.agency.modules.travel.domain.Travel
import br.com.cvinicius.agency.modules.travel.domain.TravelRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
internal class GenerateTravelUsecaseImpl(private val travelRepository: TravelRepository) : GenarateTravelUsecase {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute(newTravel: NewTravel): Mono<UUID> {

        logger.info("Inicio do processo de nova Travel ")

        return Mono.just(newTravel).map {

            logger.info("Criando objeto Travel ")

            Travel(UUID.randomUUID(), it.datetime, it.qtd, it.userId, it.providerId, it.destinyId)
        }.doOnNext {
            logger.info("Inicio da persistência. ")

            travelRepository.save(it)
        }.map {

            logger.info("Gerado uma Travel [${it.id}].")

            it.id
        }
    }
}
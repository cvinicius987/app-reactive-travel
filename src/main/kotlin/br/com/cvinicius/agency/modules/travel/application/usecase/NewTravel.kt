package br.com.cvinicius.agency.modules.travel.application.usecase

import java.time.LocalDateTime
import java.util.*

data class NewTravel(val datetime: LocalDateTime,
                     val qtd:Int,
                     val userId: UUID,
                     val providerId: UUID,
                     val destinyId: UUID
)

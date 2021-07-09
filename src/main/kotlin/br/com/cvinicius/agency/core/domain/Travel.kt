package br.com.cvinicius.agency.core.domain

import java.time.LocalDateTime
import java.util.*

class Travel(
        val id:UUID,
        val datetime:LocalDateTime,
        val userId:Long,
        val destinyId:Long,
        val providerId:Long)

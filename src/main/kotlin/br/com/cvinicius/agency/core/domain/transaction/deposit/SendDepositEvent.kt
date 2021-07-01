package br.com.cvinicius.agency.core.domain.transaction.deposit

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class SendDepositEvent(val transactionId:UUID,
                            val cardNumber:String,
                            val value:BigDecimal,
                            val datetime:LocalDateTime)
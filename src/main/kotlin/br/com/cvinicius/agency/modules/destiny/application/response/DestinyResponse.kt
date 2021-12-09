package br.com.cvinicius.agency.modules.destiny.application.response

import java.math.BigDecimal
import java.util.*

class DestinyResponse(val id:UUID,
                       val name:String,
                       val value:BigDecimal,
                       val state:String,
                       val description:String?)
package br.com.cvinicius.agency.application.api.deposit

/*
import br.com.cvinicius.agency.core.usecase.deposit.DepositCommand
import java.math.BigDecimal
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class DepositDto(

    @field:NotEmpty(message="Numero de cartão não pode ser vazio.")
    @field:Size(min = 20, max=50, message = "Numero de cartão inválido, valor deve ser entre {min} e {max}")
    var number:String = "",

    @field:NotNull
    var accountId:UUID? = null,

    @field:NotNull
    var value:BigDecimal? = null
){

    fun to() = DepositCommand(number, value!!, accountId!!)
}
*/
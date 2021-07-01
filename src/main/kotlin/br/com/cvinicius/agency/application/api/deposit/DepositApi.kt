package br.com.cvinicius.agency.application.api.deposit

/*
import br.com.cvinicius.agency.core.usecase.deposit.GenerateDepositUsecase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid


@RestController
@RequestMapping("/deposits")
class DepositApi(private val generateDepositUsecase: GenerateDepositUsecase) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun save(@Valid @RequestBody depositDto:DepositDto): Mono<Void> {

        return generateDepositUsecase.execute(depositDto.to())
    }
}

 */
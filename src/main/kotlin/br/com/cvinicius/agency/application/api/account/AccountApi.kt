package br.com.cvinicius.agency.application.api.user

import br.com.cvinicius.agency.core.domain.account.Account
import br.com.cvinicius.agency.core.domain.account.AccountRepository
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/accounts")
class AccountApi(private val accountRepository: AccountRepository) {

    @GetMapping
    fun list(): Flux<Account>{

        return accountRepository.findAll(Sort.by("code"));
    }
}
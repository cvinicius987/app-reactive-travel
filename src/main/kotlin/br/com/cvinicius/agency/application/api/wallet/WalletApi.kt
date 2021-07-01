package br.com.cvinicius.agency.application.api.wallet

import br.com.cvinicius.agency.core.domain.wallet.Wallet
import br.com.cvinicius.agency.core.domain.wallet.WalletRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.*

@RestController
class WalletApi(private val walletRepository: WalletRepository) {

    @GetMapping("{accountId}/wallet")
    fun listByAccountId(@PathVariable accountId:UUID): Flux<Wallet>{

        return walletRepository.findWalletByAccountId(accountId)
    }
}
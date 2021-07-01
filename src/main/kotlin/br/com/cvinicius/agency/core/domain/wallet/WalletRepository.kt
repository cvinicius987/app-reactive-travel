package br.com.cvinicius.agency.core.domain.wallet

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface WalletRepository{

    fun generateFromWallet(transactionId:UUID): Mono<Wallet>

    fun findWalletByAccountId(userId:UUID): Flux<Wallet>
}
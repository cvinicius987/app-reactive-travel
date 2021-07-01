package br.com.cvinicius.agency.infrastructure.dataprovider

import br.com.cvinicius.agency.core.domain.wallet.Wallet
import br.com.cvinicius.agency.core.domain.wallet.WalletRepository
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@Repository
internal class WalletRepositorySql(private val template: R2dbcEntityTemplate) : WalletRepository {

    @Transactional
    override fun generateFromWallet(transactionId: UUID): Mono<Wallet> {

        return template.insert(Wallet::class.java)
                        .using(Wallet(UUID.randomUUID(), transactionId, LocalDateTime.now()))

    }

    override fun findWalletByAccountId(userId: UUID): Flux<Wallet> {

        return template.select(Wallet::class.java)
                .from("tbl_wallet")
                .all()
    }
}
package br.com.cvinicius.agency

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.blockhound.BlockHound

@SpringBootApplication
class WalletServiceApplication

fun main(args: Array<String>) {

	BlockHound.builder()
			.with {
				it.allowBlockingCallsInside("java.util.UUID", "randomUUID")

			}.install()

	runApplication<WalletServiceApplication>(*args)
}

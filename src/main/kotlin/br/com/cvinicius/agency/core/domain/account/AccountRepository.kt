package br.com.cvinicius.agency.core.domain.account

import org.springframework.data.repository.reactive.ReactiveSortingRepository
import java.util.*

interface AccountRepository : ReactiveSortingRepository<Account, UUID>
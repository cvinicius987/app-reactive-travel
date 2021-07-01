package br.com.cvinicius.agency.core.domain.transaction.deposit

import br.com.cvinicius.agency.core.domain.Specification
import java.math.BigDecimal

internal class DepositMinimumSpecification : Specification<BigDecimal>{

    private val MINIMAL = BigDecimal.valueOf(1.00)

    override fun isEligible(instance: BigDecimal) = instance >= MINIMAL
}
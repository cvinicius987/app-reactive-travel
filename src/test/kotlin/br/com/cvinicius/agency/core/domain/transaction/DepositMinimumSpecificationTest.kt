package br.com.cvinicius.agency.core.domain.transaction

import br.com.cvinicius.agency.core.domain.transaction.deposit.DepositMinimumSpecification
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class DepositMinimumSpecificationTest {

    @Test
    fun value_to_transaction_test(){

        val value = BigDecimal.valueOf(1.01)

        val spec = DepositMinimumSpecification()

        assertTrue(spec.isEligible(value))
    }

    @Test
    fun exactly_value_to_transaction_test(){

        val value = BigDecimal.valueOf(1.00)

        val spec = DepositMinimumSpecification()

        assertTrue(spec.isEligible(value))
    }

    @Test
    fun wrong_value_to_transaction_test(){

        val value = BigDecimal.valueOf(0.99)

        val spec = DepositMinimumSpecification()

        assertFalse(spec.isEligible(value))
    }
}
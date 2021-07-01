package br.com.cvinicius.agency.core.domain.transaction

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class TransactionCategoryTest {

    @Test
    fun find_debit_category_test(){

        assertDoesNotThrow {

            val status = "DEBIT"

            TransactionCategory.valueOf(status)
        }
    }

    @Test
    fun find_credit_category_test(){

        assertDoesNotThrow {

            val status = "CREDIT"

            TransactionCategory.valueOf(status)
        }
    }

    @Test
    fun total_category_available_test(){

       assertSame(2, TransactionCategory.values().size)
    }
}
package br.com.cvinicius.agency.core.domain.transaction

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

class TransactionTest {

    @Test
    fun when_create_newDeposit_test(){

        val trans = Transaction.newDeposit(BigDecimal.valueOf(100.50), UUID.randomUUID())

        assertEquals(TransactionStatus.PENDING, trans.status)
        assertEquals(TransactionCategory.CREDIT, trans.category)
        assertTrue(trans.isNew)
    }

    @Test
    fun when_create_newDeposit_invalid_value_test(){

        assertThrows(TransactionValueException::class.java){
            Transaction.newDeposit(BigDecimal.valueOf(0.99), UUID.randomUUID())
        }
    }

    @Test
    fun when_create_newCredit_test(){

        val trans = Transaction.newCredit(BigDecimal.valueOf(100.50), UUID.randomUUID())

        assertEquals(TransactionStatus.OK, trans.status)
        assertEquals(TransactionCategory.CREDIT, trans.category)
        assertTrue(trans.isNew)
    }

    @Test
    fun when_create_newTransfer_test(){

        val trans = Transaction.newTransfer(BigDecimal.valueOf(100.50), UUID.randomUUID())

        assertEquals(TransactionStatus.OK, trans.status)
        assertEquals(TransactionCategory.DEBIT, trans.category)
        assertTrue(trans.isNew)
    }

    @Test
    fun when_create_newDebit_test(){

        val trans = Transaction.newDebit(BigDecimal.valueOf(100.50), UUID.randomUUID())

        assertEquals(TransactionStatus.OK, trans.status)
        assertEquals(TransactionCategory.DEBIT, trans.category)
        assertTrue(trans.isNew)
    }
}
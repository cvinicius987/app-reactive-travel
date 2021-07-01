package br.com.cvinicius.agency.core.domain.transaction

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class TransactionStatusTest {

    @Test
    fun find_cancel_test(){

        assertDoesNotThrow {

            val status = "CANCEL"

            TransactionStatus.valueOf(status)
        }
    }

    @Test
    fun find_pending_test(){

        assertDoesNotThrow {

            val status = "PENDING"

            TransactionStatus.valueOf(status)
        }
    }

    @Test
    fun find_ok_test(){

        assertDoesNotThrow {

            val status = "OK"

            TransactionStatus.valueOf(status)
        }
    }

    @Test
    fun total_status_available_test(){

       assertSame(3, TransactionStatus.values().size)
    }
}
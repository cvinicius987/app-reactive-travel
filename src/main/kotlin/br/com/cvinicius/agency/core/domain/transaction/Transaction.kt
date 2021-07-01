package br.com.cvinicius.agency.core.domain.transaction

import br.com.cvinicius.agency.core.domain.transaction.TransactionStatus.*
import br.com.cvinicius.agency.core.domain.transaction.TransactionCategory.*
import br.com.cvinicius.agency.core.domain.transaction.deposit.DepositMinimumSpecification
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Table(value = "tbl_transaction")
class Transaction (
        @Id
        @Column(value="id")
        val transactionId:UUID,
        val datetime:LocalDateTime,
        val value: BigDecimal,
        val status: TransactionStatus,
        val category: TransactionCategory,
        @Column(value="account_id")
        val accountId:UUID
) : Persistable<UUID>{

    @Transient
    private var newTransaction = false

    companion object {

        fun newDeposit(value: BigDecimal, accountId: UUID): Transaction {

            val spec = DepositMinimumSpecification()

            if (!spec.isEligible(value))
                throw TransactionValueException("Minimum value to transaction is [1.00]")

            return createTransaction(value, accountId, PENDING, CREDIT)
        }

        fun newCredit(value: BigDecimal, accountId:UUID) = createTransaction(value, accountId, OK, CREDIT)

        fun newTransfer(value: BigDecimal, accountId: UUID) = createTransaction(value , accountId, OK, DEBIT)

        fun newDebit(value: BigDecimal, accountId:UUID) = createTransaction(value, accountId, OK, DEBIT)

        private fun createTransaction(value: BigDecimal,
                                      accountId:UUID,
                                      status: TransactionStatus,
                                      category: TransactionCategory):Transaction{

            return Transaction(UUID.randomUUID(), LocalDateTime.now(), value, status, category, accountId).apply {
                newTransaction = true
            }
        }
    }

    fun isFinalize():Boolean{
        return status != PENDING
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transaction

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()

    @JsonIgnore
    override fun isNew() = this.newTransaction

    @JsonIgnore
    override fun getId() = transactionId
}
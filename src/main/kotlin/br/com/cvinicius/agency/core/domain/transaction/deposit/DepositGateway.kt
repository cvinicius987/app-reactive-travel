package br.com.cvinicius.agency.core.domain.transaction.deposit

interface DepositGateway {

    fun sendDeposit(sendDepositEvent: SendDepositEvent)
}
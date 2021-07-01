package br.com.cvinicius.agency.core.domain.transaction

import br.com.cvinicius.agency.core.domain.WalletException

class TransactionValueException(msg:String) : WalletException(msg)
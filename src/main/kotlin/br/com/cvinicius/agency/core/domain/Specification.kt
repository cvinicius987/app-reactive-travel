package br.com.cvinicius.agency.core.domain

interface Specification<in T> {

    fun isEligible(instance:T):Boolean
}
package br.com.cvinicius.agency.infrastructure.dataprovider.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "tbl_user")
class UserEntity(
        @Id
        val id:Long,

        val name:String)
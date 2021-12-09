package br.com.cvinicius.agency.modules.user.infra.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(value = "tbl_user")
class UserEntity(
        @Id
        val id: UUID,

        val name:String)
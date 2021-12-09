package br.com.cvinicius.agency.modules.user.infra.dao

import br.com.cvinicius.agency.modules.user.application.query.UserQuery
import br.com.cvinicius.agency.modules.user.application.response.UserResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class UserDao(private val template: R2dbcEntityTemplate) : UserQuery {

    fun UserEntity.toResponse() = UserResponse(id, name)

    override fun findAll(): Flux<UserResponse> {

        return template.select(UserEntity::class.java)
                        .from("tbl_user")
                        .all()
                        .map { it.toResponse() }
    }
}
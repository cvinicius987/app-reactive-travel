package br.com.cvinicius.agency.infrastructure.dataprovider.user

import br.com.cvinicius.agency.core.dataprovider.user.UserGateway
import br.com.cvinicius.agency.core.dataprovider.user.UserResponse
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
internal class UserGatewaySql(private val template: R2dbcEntityTemplate) : UserGateway {

    override fun findAll(): Flux<UserResponse> {

        return template.select(UserEntity::class.java)
                        .from("tbl_user")
                        .all()
                        .map { UserResponse(it.id, it.name) }
    }
}
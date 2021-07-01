package br.com.cvinicius.agency.ui.api

import br.com.cvinicius.agency.ui.api.destiny.DestinyHandler
import br.com.cvinicius.agency.ui.api.provider.ProviderHandler
import br.com.cvinicius.agency.ui.api.user.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
internal class RoutesConfig {

    @Bean
    fun userRoutes(handler: UserHandler): RouterFunction<ServerResponse> {

        return RouterFunctions.route().apply {
            GET("/user", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::getAll)
        }.build()
    }

    @Bean
    fun destinyRoutes(handler: DestinyHandler): RouterFunction<ServerResponse> {

        return RouterFunctions.route().apply {
            GET("/destiny", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::getAll)
        }.build()
    }

    @Bean
    fun providerRoutes(handler: ProviderHandler): RouterFunction<ServerResponse> {

        return RouterFunctions.route().apply {
            GET("/provider", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::getAll)
        }.build()
    }
}
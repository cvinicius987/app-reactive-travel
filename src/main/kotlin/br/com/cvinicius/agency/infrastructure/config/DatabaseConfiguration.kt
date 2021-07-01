package br.com.cvinicius.agency.infrastructure.config

import io.r2dbc.spi.ConnectionFactory
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class DatabaseConfiguration {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer? {

        logger.info("Criação do Banco de Dados")

        return ConnectionFactoryInitializer().apply {

            setConnectionFactory(connectionFactory!!)

            val popular = CompositeDatabasePopulator()

            popular.addPopulators(ResourceDatabasePopulator(ClassPathResource("schema.sql")))

            setDatabasePopulator(CompositeDatabasePopulator())
        }
    }
}
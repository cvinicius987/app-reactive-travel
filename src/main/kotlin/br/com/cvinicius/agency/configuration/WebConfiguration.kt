package br.com.cvinicius.agency.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebConfiguration {

    @Bean
    fun produceJackson(): ObjectMapper {

        return ObjectMapper().apply {
            registerModule(JavaTimeModule())
            registerModule(KotlinModule())
        }
    }
}
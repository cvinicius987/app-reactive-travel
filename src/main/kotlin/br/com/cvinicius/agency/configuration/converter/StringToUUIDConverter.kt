package br.com.cvinicius.agency.configuration.converter

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.*

@Component
class StringToUUIDConverter : Converter<String, UUID> {

    override fun convert(str: String): UUID = UUID.fromString(str)
}
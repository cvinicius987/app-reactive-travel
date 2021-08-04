package br.com.cvinicius.agency.web.converter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class StringToUUIDConverterTest{

    @Test
    fun `Convert string to UUID`(){

        val uuid = "2c3dba7a-2eb3-4568-bfdc-84c40a1e2fab"

        val converter = StringToUUIDConverter()

        Assertions.assertEquals(converter.convert(uuid), UUID.fromString(uuid))
    }

    @Test
    fun `Convert string to UUID but invalid UUID`(){

        Assertions.assertThrows(IllegalArgumentException::class.java, {

            val uuid = "2c3dba7a-2eb3-4568-bfdc-84c40adasdsadad"

            val converter = StringToUUIDConverter()

            converter.convert(uuid)

        }, "UUID string too large")
    }
}
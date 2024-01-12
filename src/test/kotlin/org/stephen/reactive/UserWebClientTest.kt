package org.stephen.reactive

import jakarta.annotation.Resource
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.stephen.reactive.web.UserWebClient

@SpringBootTest
class UserWebClientTest( ) {

    @Resource
   lateinit var userWebClient: UserWebClient

    @Test fun user(){
        val mono = userWebClient.getCode()


        mono.doOnEach {
            println(it) }.subscribe()
        mono.subscribe{
            println(it)
        }

        mono.block()
    }

}

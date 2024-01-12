package org.stephen.reactive.web

import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import reactor.core.publisher.Mono

@HttpExchange
interface UserWebClient {


    @GetExchange("/login")
    fun getLoginUser()

    @GetExchange("/code", accept = ["application/json"])
    fun getCode(): Mono<String>

}

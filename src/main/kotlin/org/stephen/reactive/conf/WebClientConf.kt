package org.stephen.reactive.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient
import org.stephen.reactive.web.UserWebClient


@Configuration
class WebClientConf {

    @Bean
    fun webClient() = WebClient.builder()
        .baseUrl("http://192.168.1.251")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultRequest{
            it.attribute("","")
        }
        .build()

    @Bean
    fun userWebClient() = HttpServiceProxyFactory.builder()
        .exchangeAdapter(WebClientAdapter.create(webClient()))
        .build()
        .createClient<UserWebClient>()

}

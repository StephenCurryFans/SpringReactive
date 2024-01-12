package org.stephen.reactive.conf


import org.springframework.beans.factory.annotation.Value
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
    fun webClient(@Value("\${base.url}") baseUrl: String = "") = WebClient.builder()
        .baseUrl(baseUrl)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build()

    @Bean
    fun userWebClient() = HttpServiceProxyFactory.builder()
        .exchangeAdapter(WebClientAdapter.create(webClient()))
        .build()
        .createClient<UserWebClient>()

}

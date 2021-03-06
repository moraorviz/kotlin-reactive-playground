package com.mario.apiclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ClientConfig {

    @Bean
    fun webClient(): WebClient {
        val httpConnector = ReactorClientHttpConnector()
        return WebClient.builder().clientConnector(httpConnector).build()
    }

    @Bean
    fun meetClient(webClient: WebClient): MeetClient {
        return MeetClient(webClient)
    }

}
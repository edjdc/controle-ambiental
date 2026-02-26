package com.github.edjdc.seguranca.config;

import java.time.Instant;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import feign.Logger;
import feign.RequestInterceptor;

@Profile({"dev", "prod"})
@Configuration
public class FeignConfig {

    @Value("${feign.accessTokenUri}")
    private String accessTokenUri;

    @Value("${feign.clientId}")
    private String clientId;

    @Value("${feign.clientSecret}")
    private String clientSecret;

    private volatile String currentToken;
    private volatile Instant expiresAt = Instant.MIN;

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        RestClient restClient = RestClient.create();

        return requestTemplate -> {
            String token = getToken(restClient);
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    private synchronized String getToken(RestClient restClient) {
        Instant now = Instant.now();
        if (currentToken != null && now.isBefore(expiresAt.minusSeconds(10))) {
            return currentToken;
        }

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);

        @SuppressWarnings("unchecked")
        Map<String, Object> response = restClient.post()
            .uri(accessTokenUri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(body)
            .retrieve()
            .body(Map.class);

        if (response == null || !response.containsKey("access_token")) {
            throw new IllegalStateException("Não foi possível obter access token");
        }

        currentToken = String.valueOf(response.get("access_token"));
        Number expiresIn = (Number) response.getOrDefault("expires_in", 30);
        expiresAt = now.plusSeconds(expiresIn.longValue());
        return currentToken;
    }
}

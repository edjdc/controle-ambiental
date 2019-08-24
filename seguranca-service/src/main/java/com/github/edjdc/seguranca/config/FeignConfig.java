package com.github.edjdc.seguranca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

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
	
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
	}
	
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

    private OAuth2ProtectedResourceDetails resource() {
        final ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri(accessTokenUri);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        return details;
    }
	
}

package com.github.edjdc.oauthserver.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Data;

@Data
@ConfigurationProperties("security")
public class SecurityProperties {

	private JwtProperties jwt;
	private String resourceId;

	@Data
	public static class JwtProperties {

		private Resource keyStore;
		private String keyStorePassword;
		private String keyPairAlias;
		private String keyPairPassword;
		private String kid;
		
	}
}

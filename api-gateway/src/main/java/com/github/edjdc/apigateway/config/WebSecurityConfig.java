package com.github.edjdc.apigateway.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/app/**", "/auth-server/**", "/actuator/**");
    }
	
}
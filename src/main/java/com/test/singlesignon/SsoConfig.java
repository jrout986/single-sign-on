package com.test.singlesignon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class SsoConfig{
	
	protected void configure(HttpSecurity http) throws Exception {
		http.oauth2Login();
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	@Bean
	public ClientRegistrationRepository repository() {
		return new InMemoryClientRegistrationRepository(clientRegistration());
	}
	
	private ClientRegistration clientRegistration() {
		return CommonOAuth2Provider.GITHUB.
				getBuilder("github")
				.clientId("7d8d8b2ef9d5132944a7")
				.clientSecret("***************").build();
	}
}

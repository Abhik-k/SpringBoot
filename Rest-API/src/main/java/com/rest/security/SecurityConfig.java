package com.rest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Authentication
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withUsername("Abhishek").password(passwordEncoder().encode("Abhishek@123")).roles("ADMIN").build();
		
		UserDetails user = User.withUsername("User").password(passwordEncoder().encode("user")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	//Authorization
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		String requestMatcher="/api/customers/**";
//		http.httpBasic(Customizer.withDefaults())
//		.authorizeHttpRequests((authorize) -> authorize.requestMatchers(HttpMethod.GET, requestMatcher)
//		.permitAll().requestMatchers(HttpMethod.PUT, requestMatcher).hasAnyRole("ADMIN", "USER")
//		.requestMatchers(HttpMethod.POST, requestMatcher).hasRole("ADMIN")
//		.requestMatchers(HttpMethod.DELETE, requestMatcher).hasRole("ADMIN").anyRequest().authenticated());
//		http.csrf(csrf -> csrf.disable());
//		http.cors(cors -> cors.configurationSource(request -> {
//			CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
//			config.addAllowedMethod(HttpMethod.PUT);
//			config.addAllowedMethod(HttpMethod.DELETE);
//			return config;
//		}));
//		return http.build();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		String requestMatcher="/api/customers/**";
		http.httpBasic(Customizer.withDefaults()) //Enables HTTP Basic Authentication.
		 .authorizeHttpRequests((authorize)->authorize.requestMatchers(HttpMethod.GET,requestMatcher).permitAll()
		 .requestMatchers(HttpMethod.PUT,requestMatcher).hasAnyRole("ADMIN","USER")
		 .requestMatchers(HttpMethod.POST,requestMatcher).hasRole("ADMIN")
		 .requestMatchers(HttpMethod.DELETE,requestMatcher).hasRole("ADMIN")
		 .anyRequest().authenticated());

		http.csrf(csrf->csrf.disable());
		
		http.cors(cors->cors.configurationSource(request->{
			CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues(); //Applies default CORS configuration values, such as allowing all origins, headers, and credentials.
			config.addAllowedMethod(HttpMethod.PUT);
			config.addAllowedMethod(HttpMethod.DELETE);
			return config;
		}));
		
		return http.build();
	}
}

package com.srore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config. Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class webConfiguration  {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser = org.springframework.security.core.userdetails
				.User
				.withUsername("user")
				.password(passwordEncoder().encode("123"))
				.roles("NORMAL")
				.build();
		
		UserDetails admin = org.springframework.security.core.userdetails
				.User
				.withUsername("admin")
				.password(passwordEncoder().encode("123"))
				.roles("ADMIN")
				.build();
		
		return new	InMemoryUserDetailsManager(normalUser,admin);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                		.requestMatchers("/home/user/**")
                		.hasRole("NORMAL")
                		.requestMatchers("/home/admin/**")
                		.hasRole("ADMIN")
                        .requestMatchers("/home/user")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                
                	.formLogin(Customizer.withDefaults());
        
        return httpSecurity.build();
	}
	}



package com.github.sidneymiranda.lojavirtual.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Profile("test")
public class TestSecurityConfiguration {

    @Bean
    public SecurityFilterChain devFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .and()
                .csrf().disable()
                .build();
    }
}

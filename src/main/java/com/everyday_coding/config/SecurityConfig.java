package com.everyday_coding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] GET_PERMITTED_URLS = {
            "/",
            "/signin",
            "/register",
    };

    private static final String[] POST_PERMITTED_URLS = {
            "/api/v1/members"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests(antz -> antz
                        .antMatchers(HttpMethod.GET, GET_PERMITTED_URLS).permitAll()
                        .antMatchers(HttpMethod.POST, POST_PERMITTED_URLS).permitAll()
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().antMatchers("/", "/css/**", "/images/**", "/js/**"));
    }
}

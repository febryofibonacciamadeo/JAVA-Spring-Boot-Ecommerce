package com.ecommerce.app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http   
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests((request) -> {
                request
                    .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/product/**")).permitAll()
                    .anyRequest().authenticated();  
            })
            .formLogin((form) -> 
                form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
            )
            .logout((logout) -> 
                logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
            return http.build();
    }
    
}

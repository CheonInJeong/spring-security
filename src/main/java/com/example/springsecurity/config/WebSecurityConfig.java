package com.example.springsecurity.config;

import com.example.springsecurity.LoginSuccessHandler;
import com.example.springsecurity.service.member.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final MemberDetailsService memberDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
                .antMatchers("/", "/index","/register","/api/v1/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                //.authenticationProvider(authenticationProvider())
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/api/v1/login")
                    .successForwardUrl("/")
                .successHandler(new LoginSuccessHandler())
                    .failureUrl("/login")
                    .permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(memberDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations()));


    }
    @Bean //userDetailService와 passwordEncoder
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

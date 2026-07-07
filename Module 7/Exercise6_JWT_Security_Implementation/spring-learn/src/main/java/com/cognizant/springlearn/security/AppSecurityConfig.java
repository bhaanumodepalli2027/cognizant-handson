package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security configuration for the JWT exercise.
 *
 * Two in-memory users are registered:
 *   user  / pwd  -> role USER
 *   admin / pwd  -> role ADMIN
 *
 * URL access rules (ORDER MATTERS — most specific first):
 *   /authenticate  -> both USER and ADMIN can call this to get a token
 *   all others     -> any authenticated request is also checked by
 *                     JwtAuthorizationFilter for a valid Bearer token
 *
 * CSRF is disabled because REST APIs are stateless and do not use
 * browser session cookies.
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppSecurityConfig.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Registering in-memory users");
        auth.inMemoryAuthentication()
                .withUser("user")
                    .password(passwordEncoder().encode("pwd"))
                    .roles("USER")
                .and()
                .withUser("admin")
                    .password(passwordEncoder().encode("pwd"))
                    .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring HTTP security rules");
        http
            .csrf().disable()
            .httpBasic()
            .and()
            .authorizeRequests()
                // /authenticate is the token-issuing endpoint — both roles allowed
                .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                // every other request must be authenticated
                .anyRequest().authenticated()
            .and()
            // Attach the JWT filter after the standard BasicAuthenticationFilter
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
    }
}

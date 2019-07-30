package com.ww.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Wojciech Wasilewski
 * @date Created on 30.07.2019
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // creating users
    @Bean
    public UserDetailsService userDetailsService() {

        // deprecated method - password not encrypted - for testing purpose only
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        // saving users in Spring Security memory - for testing purpose only
        return new InMemoryUserDetailsManager(user, admin);
    }

    // method to handle http requests from outside (user's browser)
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/hello").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll();
    }
}

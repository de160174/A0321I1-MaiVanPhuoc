package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345").roles("USER").and()
                .withUser("staff").password("{noop}12345").roles("STAFF");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").authenticated().and()
                .authorizeRequests().antMatchers("/detail/**","/search").hasRole("USER").and()
//                .authorizeRequests().antMatchers("/user**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')").and()
                .authorizeRequests().antMatchers("/create","/edit/**","/delete/**","/detail/**","/search").hasRole("STAFF")
                .and().formLogin();
    }
}

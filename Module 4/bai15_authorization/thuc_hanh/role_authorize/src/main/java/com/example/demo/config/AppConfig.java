package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomSuccessHandler successHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("{noop}123").roles("ADMIN","DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home").access("hasRole('USER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/dba/**").access("hasAnyRole('ADMIN','DBA')")
                .and().formLogin().successHandler(successHandler)
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}

package com.example.demo.config;

import com.example.demo.service.Impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailServiceImpl userDetailService;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/home").permitAll()
                .and()
                .authorizeRequests().antMatchers("/customer/","/customer/search").access("hasAnyRole('ROLE_CEO','ROLE_MANAGE','ROLE_EMPLOYEE','ROLE_USER')")
                .and().authorizeRequests()
                .antMatchers("/customer/**").access("hasAnyRole('ROLE_CEO','ROLE_MANAGE','ROLE_EMPLOYEE')")
                .and()
                .authorizeRequests().antMatchers("/contract/**").access("hasAnyRole('ROLE_CEO','ROLE_MANAGE','ROLE_EMPLOYEE')")
                .and()
                .authorizeRequests().antMatchers("/service/**").access("hasAnyRole('ROLE_CEO','ROLE_MANAGE','ROLE_EMPLOYEE')")
                .and()
                .authorizeRequests().antMatchers("/employee/**").access("hasAnyRole('ROLE_CEO','ROLE_MANAGE')")
                .and()
                .authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny")
                 // 24h
//                .tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60*60*3)//3h
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/home").failureForwardUrl("/login?error=true")
                .usernameParameter("username").passwordParameter("password")
                .and().logout().permitAll();
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds( 24 * 60 * 60); // 24h
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        // Ta lưu tạm remember me trong memory (RAM). Nếu cần mình có thể lưu trong database
        return memory;
    }
}

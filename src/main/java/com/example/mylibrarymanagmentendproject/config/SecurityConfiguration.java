package com.example.mylibrarymanagmentendproject.config;

import com.example.mylibrarymanagmentendproject.model.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .antMatchers(HttpMethod.GET, "/booking").permitAll()
                .antMatchers(HttpMethod.POST, "/booking").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.GET, "/books").hasAnyRole("USER", "ADMIN" )
                .antMatchers(HttpMethod.GET, "/books/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/books").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT, "/books").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/books").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin();


        http.httpBasic();
        http.cors();
        http.csrf().disable();
    }

}



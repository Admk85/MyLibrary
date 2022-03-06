package com.example.mylibrarymanagmentendproject.config;

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
                .antMatchers(HttpMethod.GET, "/booking").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/booking").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/booking/*").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/booking/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/booking/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.DELETE, "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET, "/books").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/books/**").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
                .and()
                .formLogin();

        http.httpBasic();
        http.cors();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

}



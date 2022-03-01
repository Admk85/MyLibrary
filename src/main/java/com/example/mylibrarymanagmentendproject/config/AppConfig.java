package com.example.mylibrarymanagmentendproject.config;

import com.example.mylibrarymanagmentendproject.model.dao.Books;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class AppConfig {

    @Bean
    public Map<Long, Books> initialData() {
        HashMap<Long, Books> map = new HashMap();
        Books b1 = new Books(1L, 2, 4634574358L, "Steven Erikson", "Władca Ciemności"
                , "fantasy", true );
        Books b2 = new Books(2L, 1, 4644533358L, "Alfred Hitchcock", "Ptaki",
                "horror", false);
        map.put(1L, b1);
        map.put(2L, b2);
        return map;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

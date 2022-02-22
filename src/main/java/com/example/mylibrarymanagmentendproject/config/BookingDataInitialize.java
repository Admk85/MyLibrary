package com.example.mylibrarymanagmentendproject.config;


import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookResponse;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;


@Component
@Order(2)
public class BookingDataInitialize implements CommandLineRunner {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        String sourceUrl = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<BookResponse[]> response = restTemplate.exchange(
                sourceUrl,
                HttpMethod.GET,
                null,
                BookResponse[].class,
                Collections.emptyMap()
        );
        BookResponse[] body = response.getBody();
        body = restTemplate.getForObject(sourceUrl, BookResponse[].class, Collections.emptyMap());

        User admin = userRepository.findByUserName("ADMIN").orElseThrow();
        Arrays.stream(body)
                .map(x -> {
                    Books books = new Books();
                    books.setId(x.getId());
                    books.setISBN(x.getId());
                    books.setTittle(x.getTitle());
                    books.setAuthor(x.getTitle());
                    books.setAccess(x.isCompleted());
                    return books;

                })
                .forEach(x -> bookRepository.save(x));
    }

}
package com.example.mylibrarymanagmentendproject.config;


import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookResponse;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
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
public class BookDataInitialize implements CommandLineRunner {

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

        User admin =  userRepository.findByUserName("ADMIN").orElseThrow();
        Arrays.stream(body)
                .map(x -> {
                    Book book = new Book();
                    book.setIsbn(x.getIsbn());
                    book.setTittle(x.getTittle());
                    book.setAuthor(x.getAuthor());
                    book.setAvailability(x.isAvailability());
                    book.setBookId(x.getBookId());
                    return book;

                })
                .forEach(x -> bookRepository.save(x));
    }

}
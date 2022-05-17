package com.example.mylibrarymanagmentendproject.config;


import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookResponse;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(Book.class);
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void run(String... args) {
        bookRepository.save(new Book(1L, 1, "5624558554", "Janek Muzykant", "wojenne rewolucje00",
                "sensacyjny", "true"));


        bookRepository.findAll().forEach((book) -> {
            logger.info("{}", book);
        });
    }
}

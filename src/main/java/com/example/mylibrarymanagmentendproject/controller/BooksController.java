package com.example.mylibrarymanagmentendproject.controller;


import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
class BooksController {

    private final BookService bookService;


    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<Books> getBooks(@RequestParam Map<String, String> params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println((params));
        return bookService.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBooks(@RequestBody List<Books> books) {
        bookService.save((Books) books);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody List<Books> books) {
        bookService.deleteByISBN((Books) books);
    }

    @RequestMapping(value = "/access", method = RequestMethod.GET)
    public List<Books> getAccess(@RequestBody List<Books> books) {
        bookService.getAllByAccess(true);
        return books;
    }
}









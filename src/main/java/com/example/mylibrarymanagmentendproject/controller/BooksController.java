package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/books")
@Slf4j
public class BooksController {

    private final BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Book book) {
        bookService.save(book);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete/{isbn}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String isbn) {
        bookService.deleteByISBN(isbn);
    }

    @RequestMapping(value = "/availability", method = RequestMethod.GET)
    public List<Book> getAvailability(@RequestAttribute("availability") boolean availability) {
        return bookService.getAvailability(true);
    }
    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public List<Book> getBooksByAuthor(String  author) {
        return bookService.getBooksByAuthor(author);
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public List<Book> getByGenre(String  genre) {
        return bookService.getByGenre(genre);
    }
    @RequestMapping(value = "/tittle", method = RequestMethod.GET)
    public List<Book> getByTittle(String  tittle) {
        return bookService.getByTittle(tittle);

    }
    @RequestMapping(value = "/copy_counts", method = RequestMethod.GET)
    public int getBookCopyCounts(@RequestAttribute("copies") Long bookId) {
        bookService.findById(bookId);{
            return bookService.getBookCopyCounts(bookId);
        }
    }
}









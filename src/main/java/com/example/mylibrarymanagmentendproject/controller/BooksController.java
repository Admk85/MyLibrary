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
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Book books) {
        bookService.save(books);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable ("id") Long bookId){
        bookService.deleteById(bookId);
    }

    @RequestMapping(value = "/availability/{id}", method = RequestMethod.GET)
    public List<Book> getAvailability( @PathVariable("id")@RequestAttribute("availability") boolean availability) {
        return bookService.getAvailability(availability);
    }
    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
    public List<Book> getByAuthor(@PathVariable("author")String  author) {
        return bookService.getByAuthor(author);
    }

    @RequestMapping(value = "/genre/{genre}", method = RequestMethod.GET)
    public List<Book> getByGenre( @PathVariable("genre") String  genre) {
        return bookService.getByGenre(genre);
    }
    @RequestMapping(value = "/tittle/{tittle}", method = RequestMethod.GET)
    public List<Book> getByTittle(@PathVariable("tittle") String  tittle) {
        return bookService.getByTittle(tittle);

    }
    @RequestMapping(value = "/copy_counts/{id}", method = RequestMethod.GET)
    public int getBookCopyCounts(@PathVariable("id") @RequestAttribute("copies") Long bookId) {
        bookService.findById(bookId);{
            return bookService.getBookCopyCounts(bookId);
        }
    }
}









package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.model.dto.BookUpdate;
import com.example.mylibrarymanagmentendproject.model.dto.BookingRequest;
import com.example.mylibrarymanagmentendproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdate update, @PathVariable("id") Long id)   {
        Book updateBook =  bookService.updateBook(update, id);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable ("id") Long bookId){
        bookService.deleteById(bookId);
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

    @RequestMapping(value = "/available/{available}", method = RequestMethod.GET)
    public List<Book> findByAvailable( @PathVariable("available") String  available) {
        return bookService.findByAvailable(available);
    }
}









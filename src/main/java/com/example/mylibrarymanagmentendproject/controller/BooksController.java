package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/books")
@Slf4j
public class BooksController {

    private final BookService bookService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Books> getBooks(@RequestParam Map<String, String> params, HttpServletRequest request, HttpServletResponse response) {
        return bookService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBooks(@RequestBody Books books) {
        bookService.save(books);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Books ISBN) {
        bookService.deleteByISBN(ISBN);
    }

    @RequestMapping(value = "/availability", method = RequestMethod.GET)
    public List<Books> getAvailability(@RequestAttribute("availability") boolean availability) {
        return bookService.getAvailability(true);

    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public List<Books> getBooksByAuthor(String  author) {
        return bookService.getBooksByAuthor(author);
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public List<Books> getByGenre(String  genre) {
        return bookService.getByGenre(genre);
    }
    @RequestMapping(value = "/tittle", method = RequestMethod.GET)
    public List<Books> getByTittle(String  tittle) {
        return bookService.getByTittle(tittle);

    }
    @RequestMapping(value = "/copy_counts", method = RequestMethod.GET)
    public int getBookCopyCounts(@RequestAttribute("copies") Long bookId) {
        bookService.findById(bookId);{
            return bookService.getBookCopyCounts(bookId);
        }
    }
}









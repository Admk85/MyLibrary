package Controller;


import Model.dao.Books;
import Model.dao.Orders;
import Repository.BookRepository;
import Repository.orderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Slf4j
class BooksController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private orderRepository repository;

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)

    public List<Books> getBooks() {
        List<Books> Bo = new ArrayList<Books>();
        bookRepository.findAll().forEach(Bo::add);
        return Bo;
    }

    @RequestMapping(value = "/getBookingDetails", method = RequestMethod.GET)
    public List<Orders> getBookingDetails() {
        List<Orders> ord = new ArrayList<Orders>();
        repository.findAll().forEach(ord::add);
        return ord;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)

    public long countNumbersBooks() {
        return bookRepository.count();
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Books());
        return "add";

    }

    @RequestMapping(value = "/delBook", method = RequestMethod.POST)
    public void delBooks(@RequestBody List<Books> books) {
        bookRepository.deleteAll(books);
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public void makeBooking(@RequestBody Orders orders) {
        repository.save(orders);

    }
    @RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
    public void cancelBooking(@RequestBody String orderInformation) {
        repository.deleteByOrderId(orderInformation);
    }
}

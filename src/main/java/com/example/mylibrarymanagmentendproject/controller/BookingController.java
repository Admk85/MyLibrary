package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {


    private  final BookingRepository repository;


    @GetMapping("/booking-details/{id}")
    public List<BookingOrder> getBookingDetails(@PathVariable String id) {
        List<BookingOrder> ord = new ArrayList<BookingOrder>();
        repository.findAll().forEach(ord::add);
        return ord;
    }
    @PostMapping("/save-booking/{id}")
    public void saveBooking(@RequestBody BookingOrder bookingOrder, @PathVariable String id) {
        repository.save(bookingOrder);
    }
        @PostMapping(value = "/cancel-Booking")
        public void cancelBooking(@RequestBody BookingOrder bookingOrder, @PathVariable Long id) {
            repository.deleteById(id);

    }
    @DeleteMapping(value = "/delete{id}")
    public void deleteBookingOrderByBookingId(@RequestBody BookingOrder bookingOrder, @PathVariable String id) {
        repository.delete(bookingOrder);
    }
}

package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.model.dto.BookingRequest;
import com.example.mylibrarymanagmentendproject.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {
    private final BookingService service;


    @RequestMapping(value = "/booking-details", method = RequestMethod.GET)
    public ResponseEntity<BookingOrder> getBookingDetails() {
        BookingOrder ord =  service.getDetails();
        {
            return new ResponseEntity<>(ord, HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<BookingOrder> addBooking(@RequestBody BookingRequest bookingRequest) {
        BookingOrder order = service.addBooking(bookingRequest);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteBooking/{bookingId}", method = RequestMethod.DELETE)
    public ResponseEntity<BookingOrder> deleteBooking(@PathVariable("bookingId") Long bookingId) {
        service.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "update/{bookingId}", method= RequestMethod.PUT)
    public ResponseEntity<BookingOrder> updateBooking(@RequestBody BookingRequest bookingRequest, @PathVariable("bookingId") Long bookingId)   {
        BookingOrder updateOrder =  service.updateBooking(bookingRequest, bookingId);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);

    }
    }


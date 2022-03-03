package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.model.dto.BookingRequest;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository orpo;


    public BookingOrder getDetails() {
        return (BookingOrder) orpo.findAll();
    }

    public void deleteBooking(Long bookingId) {
        orpo.deleteById(bookingId);
    }

    public BookingOrder addBooking(BookingRequest bookingRequest) {
        BookingOrder bookingOrder=new BookingOrder();
        bookingOrder.setUserName(bookingRequest.getUserName());
        bookingOrder.setBookingStarDate(bookingRequest.getBookingStarDate());
        bookingOrder.setBookingEndDate(bookingRequest.getBookingEndDate());
        bookingOrder.setBookId(bookingRequest.getBookId());
        bookingOrder.setAvailability(bookingRequest.getAvailability());

        return orpo.save(bookingOrder);

    }

    public BookingOrder updateBooking(BookingRequest bookingRequest, Long bookingId){
    BookingOrder bookingOrder=orpo.findById(bookingId).orElseThrow();
        bookingOrder.setUserName(bookingRequest.getUserName());
        bookingOrder.setBookingStarDate(bookingRequest.getBookingStarDate());
        bookingOrder.setBookingEndDate(bookingRequest.getBookingEndDate());
        bookingOrder.setBookId(bookingRequest.getBookId());
        bookingOrder.setAvailability(bookingRequest.getAvailability());

        return orpo.save(bookingOrder);


    }
}


   
    








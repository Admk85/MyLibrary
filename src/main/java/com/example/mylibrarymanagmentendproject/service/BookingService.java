package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository orpo;


    public BookingOrder addBooking(BookingOrder bookingOrder) {
        bookingOrder.getBooks();
        bookingOrder.getUser();
        bookingOrder.setBookingStarDate(LocalDateTime.now());
        bookingOrder.setBookingEndDate(LocalDateTime.now());
        bookingOrder.setId(1L);
        bookingOrder.getLibrary();
        return orpo.save(bookingOrder);
    }

    public BookingOrder getDetails() {
        return (BookingOrder) orpo.findAll();
    }

    public void deleteBooking(Long id) {
        orpo.deleteById(id);
    }

    public BookingOrder save(BookingOrder order) {return  orpo.save(order);
    }
}





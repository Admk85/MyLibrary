package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dto.BookingRequest;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repo;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookingOrder getDetails() {
        return (BookingOrder) repo.findAll();
    }

    public void deleteBooking(Long bookingId) {
        repo.deleteById(bookingId);
    }

    public BookingOrder addBooking(BookingRequest bookingRequest) {
        BookingOrder bookingOrder = new BookingOrder();
        Book bookById = bookRepository.findById(bookingRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book with provided id not found"));
        bookingOrder.setBook(bookById
        );
        //sprawdzic czy ilosc wypozyczen <= ilosc ksiazek
        if(repo.countByBookBookId(bookingRequest.getBookId()) >= bookById.getCopies()){
            throw new RuntimeException("cannot book the book");
        }
        bookingOrder.setUser(userRepository.findByUserCardId(bookingRequest.getUserCardId())
                .orElseThrow(() -> new RuntimeException("user with provided userCardId not found"))
        );

        bookingOrder.setBookingStarDate(Date.valueOf(bookingRequest.getBookingStartDate()));
        bookingOrder.setBookingEndDate(Date.valueOf(bookingRequest.getBookingEndDate()));

//        bookingOrder.setAvailability(bookingRequest.getAvailability());

        return repo.save(bookingOrder);

    }

    public BookingOrder updateBooking(BookingRequest bookingRequest, Long bookingId) {
        BookingOrder bookingOrder = repo.findById(bookingId).orElseThrow();
        bookingOrder.setUser(userRepository.findByUserCardId(bookingRequest.getUserCardId())
                .orElseThrow(() -> new RuntimeException("user with provided userCardId not found"))
        );
        bookingOrder.setBookingStarDate(Date.valueOf(bookingRequest.getBookingStartDate()));
        bookingOrder.setBookingEndDate(Date.valueOf(bookingRequest.getBookingEndDate()));

        bookingOrder.setBook(bookRepository.findById(bookingRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book with provided id not found"))
        );
//        bookingOrder.setAvailability(bookingRequest.getAvailability());

        return repo.save(bookingOrder);


    }
}


   
    








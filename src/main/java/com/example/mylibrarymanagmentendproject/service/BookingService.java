package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dto.BookingRequest;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repo;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;



    public void deleteBooking(Long bookingId) {
        repo.deleteById(bookingId);
    }

    public BookingOrder addBooking(BookingRequest bookingRequest) {
        BookingOrder bookingOrder = new BookingOrder();
        Book bookById = bookRepository.findById(bookingRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book with provided id not found"));
        bookingOrder.setBook(bookById
        );

        if(repo.countByBookBookId(bookingRequest.getBookId()) >= bookById.getCopies()){
            throw new RuntimeException("cannot book the book");
        }
        bookingOrder.setUser(userRepository.findByUserCardId(bookingRequest.getUserCardId())
                .orElseThrow(() -> new RuntimeException("user with provided userCardId not found"))
        );
        bookingOrder.setBookingStartDate(bookingRequest.getBookingStartDate());
        bookingOrder.setBookingEndDate( bookingRequest.getBookingEndDate());
        return repo.save(bookingOrder);
    }

    public BookingOrder updateBooking(BookingRequest bookingRequest, Long bookId) {
        BookingOrder bookingOrder = repo.findByBookingId(bookId).orElseThrow();
        bookingOrder.setUser(userRepository.findByUserCardId(bookingRequest.getUserCardId())
                .orElseThrow(() -> new RuntimeException("user with provided userCardId not found"))
        );

        bookingOrder.setBook(bookRepository.findById(bookingRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book with provided id not found"))
        );
        bookingOrder.setBookingStartDate(bookingRequest.getBookingStartDate());
        bookingOrder.setBookingEndDate( bookingRequest.getBookingEndDate());
        bookingOrder.setReturned(bookingRequest.getReturned());
        return repo.save(bookingOrder);
    }
    }



   
    








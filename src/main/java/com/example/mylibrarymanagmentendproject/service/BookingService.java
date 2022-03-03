package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository orpo;



    

    public BookingOrder getDetails() {
        return (BookingOrder) orpo.findAll();
    }

    public void deleteBooking(Long id) {
        orpo.deleteById(id);
    }

    public BookingOrder addBooking(BookRequest bookRequest) {
        BookingOrder bookingOrder=new BookingOrder();
        bookingOrder.setAuthor(bookRequest.getUserName());
        bookingOrder.setTittle(bookRequest.getAuthor());
        bookingOrder.setIsbn(bookRequest.getIsbn());
        bookingOrder.setUserName(bookRequest.getUserName());
        bookingOrder.setBookingStarDate(bookRequest.getBookingStarDate());
        bookingOrder.setBookingEndDate(bookRequest.getBookingEndDate());
        return orpo.save(bookingOrder);

    }

    public BookingOrder updateBooking(BookRequest bookRequest, Long id) {
        BookingOrder bookingOrder=new BookingOrder();
        bookingOrder.setAuthor(bookRequest.getUserName());
        bookingOrder.setTittle(bookRequest.getAuthor());
        bookingOrder.setIsbn(bookRequest.getIsbn());
        bookingOrder.setUserName(bookRequest.getUserName());
        bookingOrder.setId(bookRequest.getId());
        bookingOrder.setBookingEndDate(bookRequest.getBookingEndDate());
        return orpo.save(bookingOrder);
    }
}


   
    








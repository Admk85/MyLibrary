package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository orpo;


    public BookingOrder addBooking(BookRequest bookRequest) {
        BookingOrder bookingOrder=new BookingOrder();
        User user = new User();
        bookRequest.setISBN("");
        bookRequest.setAuthor("");
        bookRequest.setTittle("");
        user.setUserName("");
        bookRequest.setBookingStarDate(LocalDateTime.now());
        bookRequest.setBookingEndDate(LocalDateTime.now());
        bookRequest.setReturnsDate(LocalDateTime.now());
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





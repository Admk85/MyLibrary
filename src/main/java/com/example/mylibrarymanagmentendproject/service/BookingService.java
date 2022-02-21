package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository OrRepo;

    public void saveBooking(BookingOrder bookingOrder) {
        OrRepo.save(bookingOrder);
    }

    public void saveById(Long bookingId) {
        BookingOrder bookingOrder = OrRepo.getById(bookingId);
        OrRepo.save(bookingOrder);
    }

    public BookingOrder get(Long bookingId) {
        return OrRepo.findById(bookingId).get();
    }
    public List<BookingOrder> getAll() {
        List<BookingOrder> bookingOrder = (ArrayList<BookingOrder>) OrRepo.findAll();
        return bookingOrder;
    }

    public void delete(Long id) {
        OrRepo.deleteById(id);
    }
}





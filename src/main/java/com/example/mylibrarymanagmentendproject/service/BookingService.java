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

    private final BookingRepository OrRepo; //nazwa zmiennej z malej litery

    public void saveBooking(BookingOrder bookingOrder) {
        OrRepo.save(bookingOrder);
    }

    public void saveById(Long bookingId) { //ta metoda troche bez sensu, bo ona wyciaga cos z bazy, po czym zapisuje to z powrotem, wiec nie ma tutaj zadnej zmiany
        BookingOrder bookingOrder = OrRepo.getById(bookingId);
        OrRepo.save(bookingOrder);
    }

    public BookingOrder get(Long bookingId) {
        return OrRepo.findById(bookingId).get();
    }

    public List<BookingOrder> getAll() {
        List<BookingOrder> bookingOrder = (ArrayList<BookingOrder>) OrRepo.findAll(); //rzutowanie niepotrzebne, wystarczy orRepo.findAll();
        return bookingOrder;
    }

    public void delete(Long id) {
        OrRepo.deleteById(id);
    }
}





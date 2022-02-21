package com.example.mylibrarymanagmentendproject.repository;

import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingOrder, Long> {

    boolean findByBooksAndBooksReturned(Books books, boolean returned);

    boolean findByUserAndBooksReturned(User user, boolean returned);

    List<BookingOrder> findByBooksAndLibraryName(Books books, String name);
}


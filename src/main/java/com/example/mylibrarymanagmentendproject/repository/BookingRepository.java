package com.example.mylibrarymanagmentendproject.repository;
import com.example.mylibrarymanagmentendproject.model.dao.BookingOrder;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<BookingOrder, Long> {
    List<BookingOrder> findAll();
}


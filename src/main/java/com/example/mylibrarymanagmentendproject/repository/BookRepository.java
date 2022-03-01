package com.example.mylibrarymanagmentendproject.repository;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    Optional<Books> findById(Long id);
    List<Books> findAll();
    List<Books> findByAvailability(boolean a);


}

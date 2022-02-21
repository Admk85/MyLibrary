package com.example.mylibrarymanagmentendproject.repository;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    Books save(Books toSave);
    Optional<Books> findById(Long id);
    List<Books> findAll();
    void deleteByISBN(Long ISBN);
    List<Books> findAllByAccess(boolean access);
    Optional <Books> findByAuthor(String author);
    Optional <Books>findByGenre(String genre);
    List<Books> findByTittle(String tittle);

}

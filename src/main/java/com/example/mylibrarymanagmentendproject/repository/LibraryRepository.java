package com.example.mylibrarymanagmentendproject.repository;
import com.example.mylibrarymanagmentendproject.model.dao.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}

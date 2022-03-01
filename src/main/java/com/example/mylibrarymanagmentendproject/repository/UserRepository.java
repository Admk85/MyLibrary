package com.example.mylibrarymanagmentendproject.repository;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(Long id);
    Optional<Object> findByUserName(String admin);
}


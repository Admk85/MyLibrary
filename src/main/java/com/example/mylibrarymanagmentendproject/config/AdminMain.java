package com.example.mylibrarymanagmentendproject.config;

import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class AdminMain implements CommandLineRunner  {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public AdminMain(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) throws Exception {
            User users = new User();
            users.setUserName("ADMIN");
            users.setPassword(passwordEncoder.encode("Mortal"));
            userRepository.save(users);
        }
}

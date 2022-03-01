package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public List<User> addUser(UserRequest userRequest) {
        User user = new User();
        userRequest.setPesel(UUID.randomUUID().toString());
        user.setUserName("USER1");
        user.setPassword(encoder.encode("encoder"));
        user.setRegisterDate(LocalDateTime.now());
        user.setModifyDate(user.getModifyDate());
         return (List<User>) userRepository.save(user);
    }

    public void deleteUser(Long UserId) {
        userRepository.deleteById(UserId);
    }

    public List<User> getByEmail(String email) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getEmail().toLowerCase().contains(email.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

public User findUserById(Long id){
    return userRepository.findByUserId(id).orElseThrow(()-> new UsernameNotFoundException("User by id"+ id+"was not found"));


    }

    public List<User> save(User user) {
        return (List<User>) userRepository.save(user);
    }
}





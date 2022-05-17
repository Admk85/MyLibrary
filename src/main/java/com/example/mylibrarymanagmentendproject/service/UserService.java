package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public User addUser(UserRequest userRequest) {
        User user = new User();
        userRequest.setPesel(userRequest.getPesel());
        user.setUserName(userRequest.getUserName());
        user.setPassword(encoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        user.setFirstname(userRequest.getFirstname());
        user.setSurname(userRequest.getSurname());
        user.setUserCardId(UUID.randomUUID().toString());
        LocalDateTime now = LocalDateTime.now();
        user.setBirthday(java.sql.Date.valueOf(userRequest.getBirthday()));
        user.setRegisterDate(now);
        user.setModifyDate(now);
        return userRepository.save(user);
    }

    public void deleteUser(Long UserId) {
        userRepository.deleteById(UserId);
    }

    public List<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(Long id) {
        return userRepository.findByUserId(id).orElseThrow(() -> new UsernameNotFoundException("User by id" + id + "was not found"));
    }

    public User updateUser(User modification, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setUserName(modification.getUserName());
        user.setPassword(encoder.encode(modification.getPassword()));
        user.setEmail(modification.getEmail());
        user.setFirstname(modification.getFirstname());
        user.setSurname(modification.getSurname());
        user.setBirthday(modification.getBirthday());
        return userRepository.save(user);
    }
}





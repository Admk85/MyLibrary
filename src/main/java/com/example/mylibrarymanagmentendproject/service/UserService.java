package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {


     private final  UserRepository userRepository;
     private final PasswordEncoder encoder;

    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    public void saveUser(UserRequest userRequest){ //brak userRequest w kodzie, czy na pewno wszystko wrzucone na branch?
        User user=new User();
        user.setUserName("USER1");
        user.setPassword(encoder.encode("encoder"));
        user.setRegisterDate( LocalDateTime.now());
        user.setModifyDate(user.getModifyDate());
         userRepository.save(user);

    }

    public User modifyDate(User user) {
        user.setRegisterDate( LocalDateTime.now());
        return userRepository.save(user);

    }
    public void delete(Long UserId)
    { userRepository.deleteById(UserId);

    }
    public void saveById(Long Userid) {
        User users = userRepository.getById(Userid);
        userRepository.save(users);
    }
    public User getByUserId(Long userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }
    public void saveByUserCardID(Long UserCardID) {
        User user = userRepository.getById(UserCardID);
        userRepository.save(user);
    }
    public User getByUserCardID(Long UserCardID) {
        User user = userRepository.findById(UserCardID).get();
        return user;
    }

    public List<User> getByFirstname(String firstname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getFirstname().toLowerCase().contains(firstname.toLowerCase())) {
                users.add(user);
            }
        }return users;
    }
    public List<User> getBySurname(String surname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getSurname().toLowerCase().contains(surname.toLowerCase())) {
                users.add(user);
            }
        }return users;
    }

    public List<User> getByEmail(String email) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getEmail().toLowerCase().contains(email.toLowerCase())) {
                users.add(user);
            }
        }return users;
    }

    public List<User> getByFirstnameAndSurname(String firstname, String surname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getFirstname().toLowerCase().contains(firstname.toLowerCase()) &&
                    user.getSurname().toLowerCase().contains(surname.toLowerCase())) {
                users.add(user);
            }
        }return users;

}

    }





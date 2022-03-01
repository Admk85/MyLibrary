package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;
import com.example.mylibrarymanagmentendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final  UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest) {
        User newUser= (User) userService.addUser(userRequest);
        return  new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long UserId) {
        userService.deleteUser(UserId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "findUser", method= RequestMethod.GET)
    public  ResponseEntity<User> findByUserId(@PathVariable("id") Long id){
        User users= userService.findUserById(id);
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "findEmail", method= RequestMethod.GET)
    public ResponseEntity<List<User>> getByEmail(String email){
        List<User>users= userService.getByEmail(email);
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "update", method= RequestMethod.PUT)
    public ResponseEntity<User> updateUser(User user) {
        User updateUser = (User) userService.save(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }
    }





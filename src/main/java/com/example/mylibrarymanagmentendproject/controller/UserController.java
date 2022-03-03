package com.example.mylibrarymanagmentendproject.controller;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;
import com.example.mylibrarymanagmentendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final  UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@Valid  @RequestBody UserRequest userRequest) {
        User newUser= userService.addUser(userRequest);
        return  new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long UserId) {
        userService.deleteUser(UserId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "findUser/{id}", method= RequestMethod.GET)
    public  ResponseEntity<User> findByUserId(@PathVariable("id") Long id){
        User users= userService.findUserById(id);
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "findEmail/{email}", method= RequestMethod.GET)
    public ResponseEntity<List<User>> getByEmail(@PathVariable("email") String email){
        List<User>users= userService.getByEmail(email);
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id)   {
        User updateUser =  userService.updateUser(user, id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }
    }





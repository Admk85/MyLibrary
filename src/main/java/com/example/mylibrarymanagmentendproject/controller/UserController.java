package com.example.mylibrarymanagmentendproject.controller;


import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import com.example.mylibrarymanagmentendproject.role.Roles;
import com.example.mylibrarymanagmentendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private UserRepository userRepository; //nie jest finalne, wiec nie zostanie zaciagniete przy pomocy @RequiredArgsContructor

    @RequestMapping(name = "memberTypes")
    public List<String> memberTypes() {
        return Roles.MEMBER_TYPES; //czy wszystko zostalo wrzucone ? nie rozpoznaje mi MEMBER_TYPES
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) { //mamy tutaj RestController, a Model jest wykorzystywany w ramach @Controller a nie @RestController
        model.addAttribute("user", new User());
        return "/user/new-user";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) //to samo co wyzej, generalnie @Controller a nie @RestController, ponadto
    //czy template do ktorych to prowadzi nie ma w plikach, czy nie zostaly wrzucone na branch ?
    public String editUser(@PathVariable(name = "id") Long userCardID, Model model) {
        User user = userService.getByUserCardID(userCardID);
        if (user != null) {
            model.addAttribute("edition", user);
            return "/member/new-user";
        } else {
            return "redirect:/new-user/edit";
        }
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<User> listOFUsers = userRepository.findAll();
        model.addAttribute("listOFUsers", listOFUsers);
        return "show";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@Valid @PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/show";
    }
}




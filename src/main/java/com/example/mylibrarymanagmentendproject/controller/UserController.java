package com.example.mylibrarymanagmentendproject.controller;


import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.repository.UserRepository;
import com.example.mylibrarymanagmentendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private UserRepository userRepository;



    @RequestMapping(value = "/add", method = RequestMethod.GET
    )
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/add";

    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
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
    public String deleteUser(@Valid @PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/deleteUser";
    }
}




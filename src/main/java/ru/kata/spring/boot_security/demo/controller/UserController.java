package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserSecurityService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    private final UserSecurityService userDetail;
    private final UserService userService;

    @Autowired
    public UserController(UserSecurityService userDetail, UserService userService) {
        this.userDetail = userDetail;
        this.userService = userService;
    }

    @GetMapping("/user")
    public String infoAboutUser(Model model, Principal principal) {
        model.addAttribute("user", userDetail.findByName(principal.getName()));
        return "user";
    }

    @GetMapping("/user/{id}")
    public String getUserPageById(@PathVariable Long id, Model model) {
        User user = userService.showUser(id);
        model.addAttribute("user", user);
        return "user";
    }
}






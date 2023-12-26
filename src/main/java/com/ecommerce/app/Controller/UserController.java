package com.ecommerce.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.app.Entity.User;
import com.ecommerce.app.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user.getUsername(), user.getPassword());
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user) {
        User loggedUser = userService.loginUser(user.getUsername(), user.getPassword());
        if(loggedUser != null) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}

package com.boots.controller;

import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final UserService userService;
    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam Long userId,
                              @RequestParam String action) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}

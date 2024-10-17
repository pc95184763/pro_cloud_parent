package com.peng.user.controller;


import com.peng.user.entity.User;
import com.peng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User findUserByID(@PathVariable Long userId ) {
//        return userService.
        System.out.println("called");
        return userService.findUserByUserId(userId );
    }

}









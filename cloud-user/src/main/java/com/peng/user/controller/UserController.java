package com.peng.user.controller;


import com.peng.user.entity.User;
import com.peng.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public User findUserByID(@PathVariable Long userId , HttpServletRequest request) {
//        return userService.
        System.out.println("called");
        int port = request.getServerPort();
        User user =  userService.findUserByUserId(userId );

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        user.setAddress(user.getAddress()+":"+port);
        return user;
    }



}









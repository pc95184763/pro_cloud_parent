package com.peng.user.controller;


import com.peng.user.entity.User;
import com.peng.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User findUserByID(@PathVariable Long userId , HttpServletRequest request, @RequestHeader(name="Truth") String header) {
//        return userService.
        System.out.println( "User Controller header info" + header );
        int port = request.getServerPort();
        User user =  userService.findUserByUserId(userId );

//        try {
//            Thread.sleep(4900);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        user.setAddress(user.getAddress()+":"+port);
        System.out.println( user);

        return user;

    }

}









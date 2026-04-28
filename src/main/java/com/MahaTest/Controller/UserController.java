package com.MahaTest.Controller;

import com.MahaTest.Entity.UserEntity;
import com.MahaTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("https://mahastudy.in")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}
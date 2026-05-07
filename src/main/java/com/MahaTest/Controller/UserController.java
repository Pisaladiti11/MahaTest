package com.MahaTest.Controller;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Entity.UserEntity;
import com.MahaTest.Repository.MahaTestRegistrationRepository;
import com.MahaTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
//@CrossOrigin("https://mahastudy.in")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:5174",
        "https://mahastudy.in"
})
public class UserController {

    @Autowired
    private MahaTestRegistrationRepository registrationRepository;

    // GET ALL REGISTERED USERS
    @GetMapping("/all")
    public List<MahaTestRegistrationForm> getAllUsers() {

        return registrationRepository.findAll();
    }
}
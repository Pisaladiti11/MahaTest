package com.MahaTest.Controller;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.DTO.LoginRequest;
import com.MahaTest.DTO.LoginResponse;
import com.MahaTest.Service.MahaTestRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MahaTestRegistrationController {

    @Autowired
    private MahaTestRegistrationService service;

    @PostMapping("/register")
    public MahaTestRegistrationForm register(@RequestBody MahaTestRegistrationForm user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            String token = service.login(request.getMobNo(), request.getPassword());
            return ResponseEntity.ok(new LoginResponse(token)); // returns token
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new LoginResponse(e.getMessage()));
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome! You are authorized.";
    }
}
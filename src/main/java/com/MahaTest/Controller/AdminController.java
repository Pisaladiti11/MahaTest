package com.MahaTest.Controller;

import com.MahaTest.DTO.AdminLoginRequest;
import com.MahaTest.DTO.LoginResponse;
import com.MahaTest.Entity.UserEntity;
import com.MahaTest.Repository.UserRepository;
import com.MahaTest.Security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:5174",
        "https://mahastudy.in"
})
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(
            @RequestBody Map<String, String> request
    ) {

        String email = request.get("email");
        String password = request.get("password");

        if(email.equals("admin@pjsofttech.com")
                && password.equals("admin")) {

            String token = jwtUtil.generateToken(email);

            Map<String, String> response = new HashMap<>();

            response.put("token", token);

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401)
                .body("Invalid Credentials");
    }
}

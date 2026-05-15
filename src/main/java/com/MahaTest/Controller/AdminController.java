package com.MahaTest.Controller;

import com.MahaTest.DTO.AdminLoginRequest;
import com.MahaTest.DTO.LoginResponse;
import com.MahaTest.Entity.UserEntity;
import com.MahaTest.Repository.UserRepository;
import com.MahaTest.Security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> login(
            @RequestBody AdminLoginRequest request
    ) {

        UserEntity admin = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        // ADMIN NOT FOUND
        if (admin == null) {

            return ResponseEntity
                    .badRequest()
                    .body("Admin not found");
        }

        // PASSWORD CHECK
        if (!admin.getPassword().equals(request.getPassword())) {

            return ResponseEntity
                    .badRequest()
                    .body("Invalid Password");
        }

        // GENERATE JWT TOKEN
        String token = jwtUtil.generateToken(admin.getEmail());

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}
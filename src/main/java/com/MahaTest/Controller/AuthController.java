package com.MahaTest.Controller;

import com.MahaTest.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String mobNo) {
        return authService.sendOtp(mobNo);
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String mobNo,
                            @RequestParam String otp) {
        return authService.verifyOtp(mobNo, otp);
    }
}
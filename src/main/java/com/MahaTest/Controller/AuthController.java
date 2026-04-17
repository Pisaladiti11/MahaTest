package com.MahaTest.Controller;

import com.MahaTest.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private OtpService otpService;

    //  Send OTP
    @PostMapping("/send")
    public String sendOtp(@RequestParam String mobNo) {
        otpService.sendOtp(mobNo);
        return "OTP sent successfully (check console)";
    }

    //  Verify OTP
    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String mobNo,
                            @RequestParam String otp) {

        boolean result = otpService.verifyOtp(mobNo, otp);

        return result ? "OTP Verified " : "Invalid or Expired OTP ";
    }
}
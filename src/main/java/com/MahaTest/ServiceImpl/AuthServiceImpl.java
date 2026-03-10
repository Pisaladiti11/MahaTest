package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.OtpEntity;
import com.MahaTest.Repository.OtpRepository;
import com.MahaTest.Security.JwtUtil;
import com.MahaTest.Service.AuthService;
import com.MahaTest.Random.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String sendOtp(String mobNo) {

        String otp = OtpUtil.generateOtp();

        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setMobNo(mobNo);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(otpEntity);

        System.out.println("OTP : " + otp);

        return "OTP Sent Successfully";
    }

    @Override
    public String verifyOtp(String mobNo, String otp) {

        OtpEntity savedOtp = otpRepository.findById(mobNo).orElse(null);

        if (savedOtp == null)
            return "OTP not found";

        if (savedOtp.getExpiryTime().isBefore(LocalDateTime.now()))
            return "OTP Expired";

        if (!savedOtp.getOtp().equals(otp))
            return "Invalid OTP";

        return jwtUtil.generateToken(mobNo);
    }
}
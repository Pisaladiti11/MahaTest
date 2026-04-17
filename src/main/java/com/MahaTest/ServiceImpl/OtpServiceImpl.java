package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.OtpEntity;
import com.MahaTest.Repository.OtpRepository;
import com.MahaTest.Service.OtpService;
import com.MahaTest.Random.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Override
    public String sendOtp(String mobNo) {

        String otp = OtpUtil.generateOtp();

        OtpEntity entity = new OtpEntity();
        entity.setMobNo(mobNo);
        entity.setOtp(otp);

        // ⏱ expiry after 2 minutes
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(2));

        otpRepository.save(entity);

        // 🔥 For testing (console)
        System.out.println("OTP for " + mobNo + " is: " + otp);

        return otp;
    }

    @Override
    public boolean verifyOtp(String mobNo, String otp) {

        OtpEntity entity = otpRepository.findById(mobNo).orElse(null);

        if (entity == null) return false;

        // ❌ expired
        if (entity.getExpiryTime().isBefore(LocalDateTime.now())) {
            otpRepository.deleteById(mobNo);
            return false;
        }

        // ❌ wrong otp
        if (!entity.getOtp().equals(otp)) {
            return false;
        }

        // ✅ success → delete OTP
        otpRepository.deleteById(mobNo);
        return true;
    }
}
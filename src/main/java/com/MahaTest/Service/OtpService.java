package com.MahaTest.Service;

public interface OtpService {

    String sendOtp(String mobNo);

    boolean verifyOtp(String mobNo, String otp);
}
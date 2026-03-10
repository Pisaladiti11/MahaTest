package com.MahaTest.Service;

public interface AuthService {

    String sendOtp(String mobNo);

    String verifyOtp(String mobNo, String otp);
}
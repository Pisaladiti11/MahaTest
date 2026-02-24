package com.MahaTest.Service;

import com.MahaTest.Entity.MahaTestRegistrationForm;

public interface MahaTestRegistrationService {
    MahaTestRegistrationForm register(MahaTestRegistrationForm user);
    String login(String mobNo, String password);
}
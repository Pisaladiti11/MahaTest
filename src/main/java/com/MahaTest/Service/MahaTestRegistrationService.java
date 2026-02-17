package com.MahaTest.Service;

import com.MahaTest.Entity.MahaTestRegistrationForm;

import java.util.List;

public interface MahaTestRegistrationService {

    MahaTestRegistrationForm saveRegistration(MahaTestRegistrationForm form);

    MahaTestRegistrationForm getById(Long id);

    List<MahaTestRegistrationForm> getAll();

    String deleteById(Long id);
}


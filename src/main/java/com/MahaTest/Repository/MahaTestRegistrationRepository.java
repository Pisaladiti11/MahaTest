
    package com.MahaTest.Repository;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface MahaTestRegistrationRepository
            extends JpaRepository<MahaTestRegistrationForm, Long> {

        Optional<MahaTestRegistrationForm> findByMobNo(String mobNo);
    }



package com.MahaTest.Repository;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MahaTestRegistrationRepository extends JpaRepository<MahaTestRegistrationForm, Long> {
    Optional<MahaTestRegistrationForm> findByMobNo(String mobNo);
}
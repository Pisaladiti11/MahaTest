package com.MahaTest.Repository;
import com.MahaTest.Entity.OtpEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<OtpEntity, String> {
    }


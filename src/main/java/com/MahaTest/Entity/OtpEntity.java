package com.MahaTest.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
    public class OtpEntity {

        @Id
        private String mobNo;
        private String otp;
    private LocalDateTime expiryTime;

    }


package com.MahaTest.DTO;

import lombok.Data;

@Data
public class AdminLoginRequest {

    private String email;
    private String password;
}
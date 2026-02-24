package com.MahaTest.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegistrationRequest {
    private String name;
    private String mobNo;
    private String password;
    private String medium;
    private String board;
    private String gender;
    private String studentClass;
    private String school;
    private String district;
    private String groupType;
}


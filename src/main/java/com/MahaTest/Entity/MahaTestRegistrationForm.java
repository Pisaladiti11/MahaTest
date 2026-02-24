package com.MahaTest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maha_test_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MahaTestRegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String mobNo;

    private String password;

    private String medium;
    private String board;
    private String gender;

    @Column(name = "student_class")
    private String studentClass;

    private String school;
    private String district;
    private String scholarshipExam;
}
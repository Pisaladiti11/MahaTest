package com.MahaTest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maha_test_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MahaTestRegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 10, unique = true)
    private String mobNo;

    @Column(nullable = false)
    private String medium;

    @Column(nullable = false)
    private String board;

    @Column(name = "student_class", nullable = false)
    private String studentClass;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String scholarshipExam;
}

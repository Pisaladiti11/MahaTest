package com.MahaTest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "papers")
@Data
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Paper 1, 2023 Pre

    private Integer totalQuestions;

    private Integer totalMarks;

    private Integer durationMinutes;

    private String year;

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;
}

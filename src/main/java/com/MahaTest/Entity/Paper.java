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
    private String name;

    private Integer totalQuestions;

    private Integer totalMarks;

    private Integer durationMinutes;

    private String year;

    private String description;

    private String subjectQuestion;

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    // MULTIPLE SECTIONS
    @ManyToMany
    @JoinTable(
            name = "paper_sections",
            joinColumns = @JoinColumn(name = "paper_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;
}
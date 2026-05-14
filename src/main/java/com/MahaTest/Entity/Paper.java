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

    // Title
    @Column(nullable = false)
    private String name;

    // Image URL or file name
    private String image;

    // Questions
    private Integer totalQuestions;

    // Marks
    private Integer totalMarks;

    // Duration in minutes
    private Integer durationMinutes;

    // Attempt settings
    private Boolean attempt = false;

    private Integer maxAttempt;

    // Result visibility
    private Boolean result = false;

    // Solved count
    private Integer solved = 0;

    // All result visible
    private Boolean allResult = true;

    // Download enabled
    private Boolean downloadEnabled = true;

    // Status
    private boolean active = true;

    // Year
    private String year;

    private String description;

    private String subjectQuestion;

    // Exam start & end date
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    // Created time
    private LocalDateTime createdAt = LocalDateTime.now();

    // MULTIPLE SECTIONS
    @ManyToMany
    @JoinTable(
            name = "paper_sections",
            joinColumns = @JoinColumn(name = "paper_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    // Questions
    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;
}
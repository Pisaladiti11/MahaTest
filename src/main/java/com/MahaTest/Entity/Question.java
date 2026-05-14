package com.MahaTest.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Question Text
    @Column(nullable = false, length = 3000)
    private String questionText;

    // Optional Image
    private String questionImage;

    // Options
    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    // Correct Answer
    private String correctAnswer;

    // Marks
    private Integer marks;

    // Negative Marks
    private Double negativeMarks;

    // EASY / MEDIUM / HARD
    private String difficultyLevel;

    // Topic
    private String topic;

    // Explanation
    @Column(length = 3000)
    private String explanation;

    // MCQ / TRUE_FALSE / FILL_BLANK
    private String questionType;

    // Active Status
    private boolean active = true;

    // Created Time
    private LocalDateTime createdAt = LocalDateTime.now();

    // Paper Mapping
    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    // Section Mapping
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
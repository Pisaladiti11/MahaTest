package com.MahaTest.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private String correctAnswer;

    private Integer marks;

    private Double negativeMarks;

    private String difficultyLevel; // EASY, MEDIUM, HARD

    private String topic;

    private String explanation;

    private String QuestionType;

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "paper_id", nullable = false)
    private Paper paper;
}

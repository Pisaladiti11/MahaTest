package com.MahaTest.Entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "feedback_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentMobNo;

    private String message;

    private int rating;

    private String suggestions;
}

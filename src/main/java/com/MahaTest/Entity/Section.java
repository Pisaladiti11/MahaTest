package com.MahaTest.Entity;

import jakarta.persistence.*;
        import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "sections")
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}

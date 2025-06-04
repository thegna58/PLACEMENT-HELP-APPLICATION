package com.example.alumnisystem.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterviewExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String stages;
    private Double offeredPackage;
    private String difficulty;
    private String description;

    @ManyToOne
    private Alumni alumni;
}

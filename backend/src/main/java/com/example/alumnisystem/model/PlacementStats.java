package com.example.alumnisystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlacementStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String companyName;
    private int year;
    private int studentsPlaced;
    private double averagePackage;
}

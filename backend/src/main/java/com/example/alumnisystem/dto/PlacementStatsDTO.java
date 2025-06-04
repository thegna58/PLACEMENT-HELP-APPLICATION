// PlacementStatsDTO.java
package com.example.alumnisystem.dto;

public class PlacementStatsDTO {
    private Long id;
    private String role;
    private String companyName;
    private int year;
    private int studentsPlaced;
    private double averagePackage;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getStudentsPlaced() { return studentsPlaced; }
    public void setStudentsPlaced(int studentsPlaced) { this.studentsPlaced = studentsPlaced; }

    public double getAveragePackage() { return averagePackage; }
    public void setAveragePackage(double averagePackage) { this.averagePackage = averagePackage; }
}

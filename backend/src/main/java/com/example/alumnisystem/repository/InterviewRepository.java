package com.example.alumnisystem.repository;

import com.example.alumnisystem.model.InterviewExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<InterviewExperience, Long> {}

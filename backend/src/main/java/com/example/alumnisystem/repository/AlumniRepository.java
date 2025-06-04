package com.example.alumnisystem.repository;

import com.example.alumnisystem.model.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {}

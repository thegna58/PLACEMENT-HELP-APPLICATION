package com.example.alumnisystem.controller.alumni;

import com.example.alumnisystem.model.Alumni;
import com.example.alumnisystem.model.InterviewExperience;
import com.example.alumnisystem.model.QueryAnswer;
import com.example.alumnisystem.service.AlumniFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // This is critical for JavaFX or any frontend to access your Spring Boot backend
@RestController
@RequestMapping("/api/alumni")
public class AlumniController {

    @Autowired
    private AlumniFacadeService service;

    // Create new Alumni
    @PostMapping("/add")
    public ResponseEntity<Alumni> addAlumni(@RequestBody Alumni alumni) {
        Alumni savedAlumni = service.addAlumni(alumni);
        return ResponseEntity.ok(savedAlumni);
    }



    // Add interview experience by alumni ID
    @PostMapping("/{id}/experience")
    public ResponseEntity<InterviewExperience> addExperience(@PathVariable Long id, @RequestBody InterviewExperience experience) {
        InterviewExperience savedExp = service.addExperience(id, experience);
        return ResponseEntity.ok(savedExp);
    }

    // Answer query by alumni ID
    @PostMapping("/{id}/answer")
    public ResponseEntity<QueryAnswer> answerQuery(@PathVariable Long id, @RequestBody QueryAnswer answer) {
        QueryAnswer savedAnswer = service.answerQuery(id, answer);
        return ResponseEntity.ok(savedAnswer);
    }

    // Get all alumni
    @GetMapping("/")
    public ResponseEntity<List<Alumni>> getAllAlumni() {
        List<Alumni> alumniList = service.getAllAlumni();
        return ResponseEntity.ok(alumniList);
    }
}

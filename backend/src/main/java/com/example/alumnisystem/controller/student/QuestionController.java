package com.example.alumnisystem.controller.student;

import com.example.alumnisystem.model.Question;
import com.example.alumnisystem.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionController {
    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Question> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/all")
    public void deleteAll() {
    service.deleteAll();
    }

    @PostMapping
    public Question ask(@RequestBody Question q) {
        return service.askQuestion(q);
    }

    @PostMapping("/upvote/{id}")
    public Question upvote(@PathVariable Long id) {
        return service.upvote(id);
    }
    
}

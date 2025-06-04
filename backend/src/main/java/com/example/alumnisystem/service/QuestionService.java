package com.example.alumnisystem.service;

import com.example.alumnisystem.command.AskQuestionCommand;
import com.example.alumnisystem.command.UpvoteQuestionCommand;
import com.example.alumnisystem.model.Question;
import com.example.alumnisystem.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> getAll() {
        return repo.findAll();
    }

    public Question askQuestion(Question q) {
        AskQuestionCommand command = new AskQuestionCommand(repo, q);
        command.execute();
        return q; // repo.save(q) already done
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public Question upvote(Long id) {
        Question q = repo.findById(id).orElseThrow();
        UpvoteQuestionCommand command = new UpvoteQuestionCommand(repo, id);
        command.execute();
        return repo.findById(id).orElseThrow(); // updated one
    }
}

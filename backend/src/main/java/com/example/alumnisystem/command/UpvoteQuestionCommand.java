package com.example.alumnisystem.command;

import com.example.alumnisystem.model.Question;
import com.example.alumnisystem.repository.QuestionRepository;

public class UpvoteQuestionCommand implements QuestionCommand {
    private final QuestionRepository repo;
    private final Long questionId;

    public UpvoteQuestionCommand(QuestionRepository repo, Long questionId) {
        this.repo = repo;
        this.questionId = questionId;
    }

    @Override
    public void execute() {
        Question q = repo.findById(questionId).orElseThrow();
        q.setUpvotes(q.getUpvotes() + 1);
        repo.save(q);
    }
}

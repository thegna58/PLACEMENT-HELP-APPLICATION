package com.example.alumnisystem.command;

import com.example.alumnisystem.model.Question;
import com.example.alumnisystem.repository.QuestionRepository;

public class AskQuestionCommand implements QuestionCommand {
    private final QuestionRepository repo;
    private final Question question;

    public AskQuestionCommand(QuestionRepository repo, Question question) {
        this.repo = repo;
        this.question = question;
    }

    @Override
    public void execute() {
        repo.save(question);
    }
}

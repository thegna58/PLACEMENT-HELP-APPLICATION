// PostInterviewCommand.java
package com.example.alumnisystem.pattern.command;

import com.example.alumnisystem.model.InterviewExperience;
import com.example.alumnisystem.service.AlumniFacadeService;

public class PostInterviewCommand implements Command {
    private final AlumniFacadeService service;
    private final Long alumniId;
    private final InterviewExperience experience;

    public PostInterviewCommand(AlumniFacadeService service, Long id, InterviewExperience exp) {
        this.service = service;
        this.alumniId = id;
        this.experience = exp;
    }

    @Override
    public void execute() {
        service.addExperience(alumniId, experience);
    }
}

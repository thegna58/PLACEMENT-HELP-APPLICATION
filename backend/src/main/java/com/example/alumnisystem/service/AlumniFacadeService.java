package com.example.alumnisystem.service;

import com.example.alumnisystem.model.Alumni;
import com.example.alumnisystem.model.InterviewExperience;
import com.example.alumnisystem.model.QueryAnswer;
import com.example.alumnisystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumniFacadeService {

    @Autowired
    private AlumniRepository alumniRepo;

    @Autowired
    private InterviewRepository interviewRepo;

    @Autowired
    private QueryAnswerRepository answerRepo;

    public Alumni addAlumni(Alumni alumni) {
        return alumniRepo.save(alumni);
    }

    public InterviewExperience addExperience(Long alumniId, InterviewExperience experience) {
        Alumni alumni = alumniRepo.findById(alumniId).orElseThrow();
        experience.setAlumni(alumni);
        return interviewRepo.save(experience);
    }

    public QueryAnswer answerQuery(Long alumniId, QueryAnswer answer) {
        Alumni alumni = alumniRepo.findById(alumniId).orElseThrow();
        answer.setAlumni(alumni);
        return answerRepo.save(answer);
    }

    public List<Alumni> getAllAlumni() {
        return alumniRepo.findAll();
    }
}

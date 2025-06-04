package com.example.alumnisystem.pattern.iterator;

import com.example.alumnisystem.model.InterviewExperience;
import java.util.Iterator;
import java.util.List;

public class InterviewIterator implements Iterator<InterviewExperience> {
    private final List<InterviewExperience> list;
    private int position = 0;

    public InterviewIterator(List<InterviewExperience> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return position < list.size();
    }

    public InterviewExperience next() {
        return list.get(position++);
    }
}

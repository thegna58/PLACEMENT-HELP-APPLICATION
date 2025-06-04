package com.example.alumnisystem.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumni {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String company;
    private Integer passingYear;
    private Double salaryPackage;
    private Boolean anonymous;

    @OneToMany(mappedBy = "alumni", cascade = CascadeType.ALL)
    private List<InterviewExperience> interviews;

    @OneToMany(mappedBy = "alumni", cascade = CascadeType.ALL)
    private List<QueryAnswer> answers;

    public boolean isAnonymous() {
        return this.anonymous != null && this.anonymous;
    }
}

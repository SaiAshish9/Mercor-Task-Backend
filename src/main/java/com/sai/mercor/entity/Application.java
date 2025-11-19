package com.sai.mercor.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "applications")
public class Application {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String location;
    private String submitted_at;
    private List<String> work_availability;
    private Map<String, String> annual_salary_expectation;
    private List<WorkExperience> work_experiences;
    private Education education;
    private List<String> skills;
    private boolean shortlisted;
}


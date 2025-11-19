package com.sai.mercor.entity;

import lombok.Data;

@Data
public class Degree {
    private String degree;
    private String subject;
    private String school;
    private String gpa;
    private String startDate;
    private String endDate;
    private String originalSchool;
    private boolean isTop50;
}

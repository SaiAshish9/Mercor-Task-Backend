package com.sai.mercor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequestDto {
    private List<String> locations;
    private List<String> roles;
    private List<String> organizations;
    private List<String> skills;
    private boolean shortlisted;
}

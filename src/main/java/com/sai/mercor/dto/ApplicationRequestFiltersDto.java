package com.sai.mercor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequestFiltersDto {
    private List<String> skills;
    private List<String> organizations;
    private List<String> roles;
    private List<String> locations;
}

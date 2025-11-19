package com.sai.mercor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationShortlistRequestDto {
    private String id;
    private boolean shortlisted;
}

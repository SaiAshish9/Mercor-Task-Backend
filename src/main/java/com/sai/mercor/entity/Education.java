package com.sai.mercor.entity;

import lombok.Data;
import java.util.List;

@Data
public class Education {
    private String highestLevel;
    private List<Degree> degrees;
}


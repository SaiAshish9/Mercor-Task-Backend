package com.sai.mercor.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkAvailability {
    FULL_TIME("full-time"),
    PART_TIME("part-time");

    private final String value;

    WorkAvailability(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

package com.sai.mercor.utilities;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;

@UtilityClass
public class ApplicationUtilities {

    public static List<String> nonEmptySorted(List<String> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .distinct()
                .sorted()
                .toList();
    }

}

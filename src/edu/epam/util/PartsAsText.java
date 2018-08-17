package edu.epam.util;

import edu.epam.entity.ComputerCaseType;
import edu.epam.entity.PartType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartsAsText {
    private static final List<String> computerParts = createElementList(Arrays.asList(PartType.values()));
    private static final List<String> computerCases = createElementList(Arrays.asList(ComputerCaseType.values()));

    private static List<String> createElementList(List<?> elements) {
        List<String> parts = new ArrayList<>();
        for (Object element : elements) {
            parts.add(element.toString());
        }
        return parts;
    }

    public static List<String> getComputerParts() {
        return computerParts;
    }

    public static List<String> getComputerCases() {
        return computerCases;
    }
}

package edu.epam.validator;

import edu.epam.util.PartsAsText;

import java.util.List;

public class OrderInfoValidator {
    private static final String DIGIT_REGEX = "\\d+";
    private static final String LATIN_CHARS = "^[a-zA-Z ]+$";
    private static final int NAME_MIN_LENGTH = 4;
    private static final int NAME_MAX_LENGTH = 20;
    private static final int CUSTOMER_ID_LENGTH = 5;
    private static final List<String> allComponents = PartsAsText.getComputerParts();
    private static final List<String> allCases = PartsAsText.getComputerCases();

    public boolean isValidCustomerId(String customerId) {
        return customerId.matches(DIGIT_REGEX) && customerId.length() == CUSTOMER_ID_LENGTH;
    }

    public boolean isValidComputerName(String computerName) {
        computerName.replace("_", " ");
        return computerName.matches(LATIN_CHARS) && computerName.length() >= NAME_MIN_LENGTH && computerName.length() <= NAME_MAX_LENGTH;
    }

    public boolean isValidComputerAmount(String amount) {
        return amount.matches(DIGIT_REGEX) && Integer.parseInt(amount) < 10 && Integer.parseInt(amount) > 0;
    }

    public boolean isComputerCaseSet(String computerCase) {
        return allCases.contains(computerCase);
    }

}

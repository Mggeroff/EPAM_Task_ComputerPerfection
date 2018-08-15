package edu.epam.validator;

public class CustomerInfoValidator {
    // TODO: format according to my PSF fields
    static final String DIGIT_REGEX = "\\d+";
    private static final String LATIN_CHARS = "^[a-zA-Z ]+$";
    // TODO: put constants in separate file???
    private static final int NAME_MIN_LENGTH = 4;
    private static final int NAME_MAX_LENGTH = 20;
    private static final int CUSTOMER_ID_LENGTH = 5;

    public boolean isValidCustomer(String customerId) {
        return customerId.matches(DIGIT_REGEX) && customerId.length() == CUSTOMER_ID_LENGTH;
    }

    public boolean isValidComputerName(String computerName) {
        return computerName.matches(LATIN_CHARS) && computerName.length() >= NAME_MIN_LENGTH && computerName.length() <= NAME_MAX_LENGTH;
    }
}

package io.stene.nationalregistry.validator;

import io.stene.nationalregistry.exception.ValidationException;

public class SSNValidator {

    public static void validate(String ssn) {
        validateSsnLength(ssn);
        validateDayOfMonth(ssn);
    }

    private static void validateSsnLength(String ssn) {
        if (ssn.length() != 11) {
            throw new ValidationException("Invalid SSN");
        }
    }

    private static void validateDayOfMonth(String ssn) {
        int day = Integer.parseInt(ssn.substring(0,2));

        if (day < 1 || day > 31) {
            throw new ValidationException("Day of month is out of range");
        }
    }
}

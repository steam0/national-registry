package io.stene.nationalregistry.validator;

import io.stene.nationalregistry.exception.ValidationException;

public class SSNValidator {

    public static void validate(String ssn) {
        validateSsnLength(ssn);
    }


    private static void validateSsnLength(String ssn) {
        if (ssn.length() != 11) {
            throw new ValidationException("Invalid SSN");
        }
    }

}

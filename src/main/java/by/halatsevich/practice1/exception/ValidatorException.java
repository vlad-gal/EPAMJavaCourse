package by.halatsevich.practice1.exception;

/**
 * Custom exception for validator
 *
 * @author Vladislav Halatsevich
 */

public class ValidatorException extends Exception {
    public ValidatorException() {
    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorException(Throwable cause) {
        super(cause);
    }

}

package edu.epam.exception;

public class WrongOrderException extends Exception {
    public WrongOrderException() {
    }

    public WrongOrderException(String message) {
        super(message);
    }

    public WrongOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongOrderException(Throwable cause) {
        super(cause);
    }
}

package edu.epam.exception;

@Deprecated
public class ComputerException extends Exception {
    private String message;

    public ComputerException(String message) {
        this.message = message;
    }

    public String getInfo() {
        return message;
    }
}

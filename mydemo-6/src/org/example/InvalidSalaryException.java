package org.example;

public class InvalidSalaryException extends RuntimeException {

    private String message;


    public InvalidSalaryException(String s) {
        message=s;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

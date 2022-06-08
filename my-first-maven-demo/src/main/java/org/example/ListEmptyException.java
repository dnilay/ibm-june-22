package org.example;

public class ListEmptyException extends RuntimeException{

    private String message;

    public ListEmptyException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

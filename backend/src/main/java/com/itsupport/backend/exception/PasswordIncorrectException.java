package com.itsupport.backend.exception;

public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException ( String message ) {
        super( message );
    }
}

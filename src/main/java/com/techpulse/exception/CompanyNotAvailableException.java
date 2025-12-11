package com.techpulse.exception;

public class CompanyNotAvailableException extends  RuntimeException{
    public CompanyNotAvailableException(String message) {
        super(message);
    }
}

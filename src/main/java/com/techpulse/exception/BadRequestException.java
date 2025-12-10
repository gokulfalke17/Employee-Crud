package com.techpulse.exception;

import com.techpulse.entity.Employee;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}

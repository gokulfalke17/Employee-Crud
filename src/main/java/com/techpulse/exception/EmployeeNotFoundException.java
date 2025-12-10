package com.techpulse.exception;

import com.techpulse.entity.Employee;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

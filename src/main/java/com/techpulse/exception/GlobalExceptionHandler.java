package com.techpulse.exception;

import com.techpulse.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmployeeNotFound(EmployeeNotFoundException exception) {
        return  new ResponseEntity<>(
                new ApiResponse(false, exception.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequest(BadRequestException exception) {
        return new ResponseEntity<>(
                new ApiResponse(false, exception.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneral(Exception exception) {
        return  new ResponseEntity<>(
                new ApiResponse(false, exception.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}

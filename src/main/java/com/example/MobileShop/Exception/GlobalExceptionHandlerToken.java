package com.example.MobileShop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerToken {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("type", "about:blank");
        errorDetails.put("title", "Bad Request");
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());

        // Extract field errors
        Map<String, String> fieldErrors = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // Customize the detail message
        StringBuilder detailMessage = new StringBuilder("Validation failed: ");
        fieldErrors.forEach((field, message) -> {
            detailMessage.append(field).append(" ").append(message).append("; ");
        });
        errorDetails.put("detail", detailMessage.toString());

        errorDetails.put("description", "Validation error.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(Exception exception) {
        // Handle other exceptions here if needed
        // For simplicity, returning a generic error response
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("type", "about:blank");
        errorDetails.put("title", "Internal Server Error");
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.put("detail", exception.getMessage());
        errorDetails.put("description", "Unknown internal server error.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
}

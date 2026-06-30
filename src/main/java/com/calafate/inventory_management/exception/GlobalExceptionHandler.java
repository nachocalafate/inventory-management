package com.calafate.inventory_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),                    // timestamp
                HttpStatus.NOT_FOUND.value(),                 // status como número (404, 400, 500)
                ex.getMessage(),                         // el mensaje de la excepción
                request.getDescription(false)            // la URL del request
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Se usa el 404 not found para manejar excepciones not found
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientStock(InsufficientStockException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),                    // timestamp
                HttpStatus.BAD_REQUEST.value(),                 // status como número (404, 400, 500)
                ex.getMessage(),                         // el mensaje de la excepción
                request.getDescription(false)       // request.getDescription(false) devuelve: "uri=/api/branches/1"
                                                                // request.getDescription(true) devuelve: "uri=/api/branches/1;client=0:0:0:0:0:0:0:1"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),                    // timestamp
                HttpStatus.INTERNAL_SERVER_ERROR.value(),                 // status como número (404, 400, 500)
                ex.getMessage(),                         // el mensaje de la excepción
                request.getDescription(false)            // la URL del request
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                message,
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
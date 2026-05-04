package com.raghav.transactions.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String,String>> handle(AccountNotFoundException ex) {

        Map<String,String> m = new HashMap<>();
        m.put("error", ex.getMessage());

        return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<Map<String,String>> handle2(InsufficientFundsException ex) {

        Map<String,String> m = new HashMap<>();
        m.put("error", ex.getMessage());

        return new ResponseEntity<>(m, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SameAccountTransferException.class)
    public ResponseEntity<Map<String, String>> handleSameAccount(SameAccountTransferException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
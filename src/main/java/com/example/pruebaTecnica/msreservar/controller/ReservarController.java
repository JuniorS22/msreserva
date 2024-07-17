package com.example.pruebaTecnica.msreservar.controller;


import com.example.pruebaTecnica.msreservar.dto.ReservarRequest;
import com.example.pruebaTecnica.msreservar.entity.Reservar;
import com.example.pruebaTecnica.msreservar.exception.InvalidDiscountException;
import com.example.pruebaTecnica.msreservar.service.ReservarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bideafactory/book")
public class ReservarController {

    @Autowired
    private ReservarService reservarService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createReservation(@Valid @RequestBody ReservarRequest request) {
        Reservar reservation = reservarService.createReservation(request);

        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "Book Accepted");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            Map<String, String> errorDetails = new HashMap<>();
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorDetails.put("field", fieldName);
            errorDetails.put("message", errorMessage);
            errors.add(errorDetails);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Bad Request");
        response.put("messages", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDiscountException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, Object>> handleInvalidDiscountException(InvalidDiscountException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CONFLICT.value());
        response.put("error", "conflict");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}

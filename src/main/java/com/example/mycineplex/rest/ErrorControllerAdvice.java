package com.example.mycineplex.rest;

import com.example.mycineplex.Dto.Errordto;
import com.example.mycineplex.entity.Movie;
import com.example.mycineplex.exception.CustomerNotFoundException;
import com.example.mycineplex.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Errordto> handleCustomerNF(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errordto.builder()
                .message(ex.getMessage())
                .errorcode(1001)
                .erorrdate(new Date())
                .build());

    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Errordto> handleMovieNF(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errordto.builder()
                .message(ex.getMessage())
                .errorcode(1005)
                .erorrdate(new Date())
                .build());

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Errordto> handleNull(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errordto.builder()
                .message(ex.getMessage())
                .errorcode(1209)
                .erorrdate(new Date())
                .build());

    }
}
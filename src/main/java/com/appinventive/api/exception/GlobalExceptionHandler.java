package com.appinventive.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleMovieNotFoundException(MovieNotFoundException ex,
                                                                         WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleUserNotFoundException(UserNotFoundException ex,
                                                                         WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);

    }
}

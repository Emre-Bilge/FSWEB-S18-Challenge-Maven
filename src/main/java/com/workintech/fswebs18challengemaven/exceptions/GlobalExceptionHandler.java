package com.workintech.fswebs18challengemaven.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(CardException cardException)
    {
        CardErrorResponse errorResponse = new CardErrorResponse(cardException.getHttpStatus().value(), cardException.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, cardException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(Exception exception)
    {
        CardErrorResponse errorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<CardErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

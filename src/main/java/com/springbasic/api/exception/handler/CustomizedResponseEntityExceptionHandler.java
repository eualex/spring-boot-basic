package com.springbasic.api.exception.handler;

import com.springbasic.api.exception.ExceptionResponse;
import com.springbasic.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException (Exception e, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "internal.error",
                "Ocorreu um erro desconhecido",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "item.not.found",
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}

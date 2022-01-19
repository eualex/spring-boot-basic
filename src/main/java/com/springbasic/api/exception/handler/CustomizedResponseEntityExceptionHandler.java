package com.springbasic.api.exception.handler;

import com.springbasic.api.exception.ExceptionResponse;
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
                500
        );

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(PersonException.class)
//    public final ResponseEntity<ExceptionResponse> handlePersonExceptionExceptions(Exception e, WebRequest req) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                "person.not.found", "Person not found", HttpStatus.NOT_FOUND
//        );
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}

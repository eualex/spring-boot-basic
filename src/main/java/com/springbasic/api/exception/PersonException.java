package com.springbasic.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonException extends RuntimeException {

    public PersonException(String exception) {
        super(exception);
    }
}

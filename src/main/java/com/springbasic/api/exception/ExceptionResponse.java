package com.springbasic.api.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String code;
    private String message;
    private Integer status;
}

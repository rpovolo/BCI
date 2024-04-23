package com.bci.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BasicApiException extends RuntimeException{
    private final HttpStatus status;
    private final String message;
}

package ru.dmitrenko.demowebflux.exception;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
@Setter
@ToString
public class ClientResponseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final HttpHeaders httpHeaders;
    private final String bodyErrorResponse;

    public ClientResponseException(HttpStatus httpStatus, HttpHeaders httpHeaders, String bodyErrorResponse) {
        this.httpStatus = httpStatus;
        this.httpHeaders = httpHeaders;
        this.bodyErrorResponse = bodyErrorResponse;
        log.error("Error ClientResponseException. Body={} HttpStatus = {} ", bodyErrorResponse, httpStatus);
    }
}

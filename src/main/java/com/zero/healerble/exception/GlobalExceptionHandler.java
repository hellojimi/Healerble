package com.zero.healerble.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ExceptionResponse.class)
  protected ResponseEntity<ErrorResponse> handelCustomException(ExceptionResponse e) {
    log.error("{} is occurred", e.getStatusCode());

    ErrorResponse response =
        ErrorResponse.builder()
            .statusCode(e.getStatusCode())
            .errorMsg(e.getErrorMsg())
            .build();

    return new ResponseEntity<>(response, HttpStatus.resolve(e.getStatusCode()));
  }

}

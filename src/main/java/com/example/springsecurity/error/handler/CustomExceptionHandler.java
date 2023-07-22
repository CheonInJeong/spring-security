package com.example.springsecurity.error.handler;

import com.example.springsecurity.error.type.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> handleCustomException(CustomException e) {
        log.info("------------handle custom exception----------");
        log.info(e.getMessage());
        log.info("------------handle custom exception----------");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache");
        return ResponseEntity.ok()
                .headers(headers)
                .body("SUCCESS");

    }
}

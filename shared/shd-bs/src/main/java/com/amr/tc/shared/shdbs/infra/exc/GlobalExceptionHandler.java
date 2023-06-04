package com.amr.tc.shared.shdbs.infra.exc;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ErrorDto handleCarDomainException(Exception e) {
        return ErrorDto.builder()
                       .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                       .message( e.getMessage())
                       .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleCarDomainException(ValidationException e) {

        ErrorDto errorDTO;
        if (e instanceof ConstraintViolationException) {
            String violations = extractViolationsFromException((ConstraintViolationException) e);
            errorDTO = ErrorDto.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(violations).build();
        } else {
            log.error("Error occurred: {}", e.getMessage());
            errorDTO =
                    ErrorDto.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(e.getMessage()).build();
        }
        return errorDTO;
    }

    private String extractViolationsFromException(ConstraintViolationException e) {

        return e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("->"));
    }

}

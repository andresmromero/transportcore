package com.amr.tc.bs.car.carifr.exc;

import com.amr.tc.bs.car.cardom.main.exc.CarDomainException;
import com.amr.tc.bs.car.cardom.main.exc.CarNotFoundException;
import com.amr.tc.shared.shdbs.infra.exc.ErrorDto;
import com.amr.tc.shared.shdbs.infra.exc.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class CarGlobalException extends GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {CarDomainException.class})
    @ResponseBody
    public ErrorDto handleCarDomainException(CarDomainException e) {


        return ErrorDto.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(e.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {CarNotFoundException.class})
    @ResponseBody
    public ErrorDto handleCarDomainException(CarNotFoundException e) {

        return ErrorDto.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message(e.getMessage()).build();
    }

}

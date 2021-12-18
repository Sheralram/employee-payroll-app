package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<ResponseDto> handleCustomException(NoDataFoundException noDataFoundException) {
        return new ResponseEntity<ResponseDto>(new ResponseDto(noDataFoundException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseDto> handleValidationException(ValidationException validationException) {
        return new ResponseEntity<>(new ResponseDto(validationException.getMessage(), null), HttpStatus.NOT_FOUND);
    }


}

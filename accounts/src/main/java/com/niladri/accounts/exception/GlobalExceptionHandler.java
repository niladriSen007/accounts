package com.niladri.accounts.exception;

import com.niladri.accounts.dto.common.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExist.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistException
            (CustomerAlreadyExist ex,WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    };


    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException
            (ResourceNotFound ex,WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    };
}

/*package com.example.servery.error;

import com.example.servery.entity.ErrorMassage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMassage> handleException(DepartmentNotFoundException  ex, WebRequest request)
    {
        ErrorMassage errorMassage = new ErrorMassage(HttpStatus.NOT_FOUND,ex.getMessage());
        return new ResponseEntity<>(errorMassage,HttpStatus.NOT_FOUND);
    }

}*/
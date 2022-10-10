package com.kelechi.hexad_assesment.rest_exception_handler;

import com.kelechi.hexad_assesment.dto.ErrorObject;
import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject HandleProcessingException(ProcessingException ex){
        ErrorObject errorObject = new ErrorObject();
         errorObject.setMessage(ex.getMessage());
         return errorObject;
    }
}

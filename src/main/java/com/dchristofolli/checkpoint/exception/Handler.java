package com.dchristofolli.checkpoint.exception;

import com.mongodb.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Handler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorModel handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ErrorModelBuilder.anErrorModel()
            .withError(e.getClass().getName())
            .withMessage("Invalid form")
            .withStatus(HttpStatus.BAD_REQUEST)
            .withFormErrors(errors)
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiException.class)
    public ErrorModel apiExceptionValidator(ApiException e) {
        return ErrorModelBuilder.anErrorModel()
            .withMessage(e.getMessage())
            .withError(e.getClass().getName())
            .withStatus(e.getStatus())
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateKeyException.class)
    public ErrorModel handleDuplicateKeyException(DuplicateKeyException e) {
        return ErrorModelBuilder.anErrorModel()
            .withMessage("The value already exists in the database")
            .withError(e.getClass().getName())
            .withStatus(HttpStatus.BAD_REQUEST)
            .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorModel handleException(Exception e) {
        return ErrorModelBuilder.anErrorModel()
            .withMessage("Unexpected Error")
            .withError(e.getClass().getName())
            .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
    }
}


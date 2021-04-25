package com.allegro.zad3v2;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@RestController
public class serverError {
    // dla wyjatow po stronie github API
    @ExceptionHandler(WebClientResponseException.class)
    public MainController.ErrorResponse handleAllError(WebClientResponseException err) {
        MainController.ErrorResponse errorResponse = new MainController.ErrorResponse();
        errorResponse.setMessage(err.getMessage());
        errorResponse.setErrorCode(String.valueOf(err.getRawStatusCode()));
        return errorResponse;
    }

    // dla pozostalych wyjatkow po stronie serwera lokalnego
    @ExceptionHandler(Exception.class)
    public MainController.ErrorResponse handleAllError(Exception err) {
        MainController.ErrorResponse errorResponse = new MainController.ErrorResponse();
        errorResponse.setMessage("Local server error: " + err.getMessage());
        errorResponse.setErrorCode("500");
        return errorResponse;
    }
}

package com.example.thisweek7task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> userNotFound(ResourceNotFoundException ne){
      ErrorView errorView = new ErrorView();
      errorView.setStatus(HttpStatus.NOT_FOUND);
      errorView.setMessage(ne.getMessage());
      errorView.setDebugMessage(ne.getDebugMessage());
      return new ResponseEntity<>(errorView, HttpStatus.NOT_FOUND);
    }
}

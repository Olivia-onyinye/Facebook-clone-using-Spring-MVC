package com.example.thisweek7task.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorView {
    private HttpStatus status;
    private String message;
    private String debugMessage;
}

package com.kameleoon.techtask.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserNotFoundException extends RuntimeException{
    private String errorMessage;
}

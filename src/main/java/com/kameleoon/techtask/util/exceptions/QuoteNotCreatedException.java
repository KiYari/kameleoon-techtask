package com.kameleoon.techtask.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QuoteNotCreatedException extends RuntimeException{
    private String errorMessage;
}

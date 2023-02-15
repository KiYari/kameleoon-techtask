package com.kameleoon.techtask.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteNotFoundException extends RuntimeException{
    String errorMessage;
}

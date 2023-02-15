package com.kameleoon.techtask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QuoteDto {
    private String content;
    private int authorId;
}

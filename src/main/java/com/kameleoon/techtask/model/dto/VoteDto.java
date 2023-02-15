package com.kameleoon.techtask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VoteDto {
    private boolean isUpvoted;
    private int quoteId;
    private int voterId;
}

package com.kameleoon.techtask.model.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private String name;
    @Email
    private String email;
    private String password;
}

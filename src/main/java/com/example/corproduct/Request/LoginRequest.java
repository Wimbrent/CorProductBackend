package com.example.corproduct.Request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = "Email is required.")
    @Email(message = "Email is not well formatted.")
    private String email;
    @NotBlank(message = "Password is required.")
    private String password;
}

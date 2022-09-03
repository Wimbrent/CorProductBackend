package com.example.corproduct.Request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {
    @NotBlank(message = "First name is required.")
    private String firstName;
    @NotBlank(message = "Last name is required.")
    private String lastName;
    @NotBlank(message = "Email is required.")
    @Email(message = "Email is not well formatted.")
    private String email;
    @NotBlank(message = "Password is required.")
    private String password;
    private String userName;
    private String phone;
    private String question;
    private String answer;
}

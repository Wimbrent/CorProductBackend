package com.example.teashop.Request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String phone;
    private String address;
}

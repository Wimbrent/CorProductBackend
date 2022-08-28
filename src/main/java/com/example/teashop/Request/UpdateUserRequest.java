package com.example.teashop.Request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String phone;
    private String address;
}

package com.example.teashop.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private String userName;
    private String token;
    private String tokenType = "Bearer ";
    private Long id;
    public JwtResponse(String accessToken, Long id, String firstName, String lastName, String userName,
                       String email, String phone, String address) {
        this.token = accessToken;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.email = email;
    }
}

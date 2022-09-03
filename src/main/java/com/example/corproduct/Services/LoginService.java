package com.example.corproduct.Services;

import com.example.corproduct.Models.User;
import com.example.corproduct.Request.LoginRequest;
import com.example.corproduct.Response.JwtResponse;
import com.example.corproduct.Security.JWT.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtHelper jwtHelper;

    public ResponseEntity<?> login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtHelper.generateJWTToken(authentication);
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getPhone()));
    }
}

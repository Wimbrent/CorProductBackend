package com.example.corproduct.Controllers;

import com.example.corproduct.Request.LoginRequest;
import com.example.corproduct.Response.MessageResponse;
import com.example.corproduct.Services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<MessageResponse> login(@Valid @RequestBody LoginRequest request) {
        return (ResponseEntity<MessageResponse>) loginService.login(request);
    }

    @GetMapping
    public String login2() {
        return "login";
    }
}

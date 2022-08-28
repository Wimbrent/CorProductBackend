package com.example.teashop.Controllers;

import com.example.teashop.Request.RegisterRequest;
import com.example.teashop.Services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody RegisterRequest request)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        return registerService.registration(request);
    }
}

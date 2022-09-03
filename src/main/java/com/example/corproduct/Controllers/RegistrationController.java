package com.example.corproduct.Controllers;

import com.example.corproduct.Request.RegisterRequest;
import com.example.corproduct.Services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegisterService registerService;

    @PostMapping
    public String registration(@Valid @RequestBody RegisterRequest request) {
        return registerService.registration(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerService.confirmToken(token);
    }
}

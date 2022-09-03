package com.example.corproduct.Controllers;

import com.example.corproduct.Repository.UserRepository;
import com.example.corproduct.Request.UpdateUserRequest;
import com.example.corproduct.Response.MessageResponse;
import com.example.corproduct.Services.UpdateUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class UpdateUserController {

    @Autowired
    UserRepository userRepository;
    private final UpdateUserService updateUserService;
    @GetMapping("/profile/update")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @PutMapping("/profile/update/{id}")
    public ResponseEntity<MessageResponse> updateUser(@Valid @PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return (ResponseEntity<MessageResponse>) updateUserService.updateUser(id, request);
    }
}

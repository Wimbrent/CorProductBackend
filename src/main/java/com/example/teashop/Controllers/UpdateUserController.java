package com.example.teashop.Controllers;

import com.example.teashop.Models.User;
import com.example.teashop.Repository.UserRepository;
import com.example.teashop.Services.UpdateUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
@PreAuthorize("hasRole('USER')")
public class UpdateUserController {

    @Autowired
    UserRepository userRepository;
    private final UpdateUserService updateUserService;

    @GetMapping("/profile/update")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


    @PutMapping("/profile/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        return updateUserService.updateUser(id, user);
    }
}

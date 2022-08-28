package com.example.teashop.Services;

import com.example.teashop.Models.User;
import com.example.teashop.Models.UserRole;
import com.example.teashop.Repository.UserRepository;
import com.example.teashop.Request.RegisterRequest;
import com.example.teashop.Response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class RegisterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public ResponseEntity<?> registration(@RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: emails is already taken!"));
        }
        if (userRepository.existsUserByUserName(request.getUserName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: username is already taken!"));
        }
        User user = new User(request.getFirstName(), request.getLastName(), request.getUserName(), request.getEmail(),
                request.getPhone(), request.getAddress(), encoder.encode(request.getPassword()), UserRole.USER);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("user Registered successfully!"));
    }
}

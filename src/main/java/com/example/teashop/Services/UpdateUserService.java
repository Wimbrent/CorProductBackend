package com.example.teashop.Services;

import com.example.teashop.Models.User;
import com.example.teashop.Repository.UserRepository;
import com.example.teashop.Response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UpdateUserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> updateUser(Long id, User user) {
        User updateUser = userRepository.findById(id).orElseThrow();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUserName(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setAddress(user.getAddress());
        userRepository.save(updateUser);
        return ResponseEntity.ok(new MessageResponse("User update successfully!"));
    }
}

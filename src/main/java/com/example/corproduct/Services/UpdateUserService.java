package com.example.corproduct.Services;

import com.example.corproduct.Models.User;
import com.example.corproduct.Repository.UserRepository;
import com.example.corproduct.Request.UpdateUserRequest;
import com.example.corproduct.Response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UpdateUserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User updateUser = userRepository.findById(id).orElseThrow();
        updateUser.setFirstName(updateUserRequest.getFirstName());
        updateUser.setLastName(updateUserRequest.getLastName());
        updateUser.setUserName(updateUserRequest.getUserName());
        updateUser.setEmail(updateUserRequest.getEmail());
        updateUser.setPhone(updateUserRequest.getPhone());
        userRepository.save(updateUser);
        return ResponseEntity.ok(new MessageResponse("User update successfully!"));
    }
}

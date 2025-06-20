package com.Company.user_service.controller;

import com.Company.user_service.dto.UserDTO;
import com.Company.user_service.dto.response.UserResponseDTO;
import com.Company.user_service.model.User;
import com.Company.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping("/username/{name}")
    public ResponseEntity<UserResponseDTO> getUserByName(@PathVariable String name) {
        User user = userService.findByUserName(name);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByMailId(@PathVariable String email) {
        User user = userService.findByEmailID(email);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        return ResponseEntity.ok(userResponseDTO);
    }
}

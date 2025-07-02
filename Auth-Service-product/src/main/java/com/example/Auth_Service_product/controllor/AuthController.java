package com.example.Auth_Service_product.controllor;

import com.example.Auth_Service_product.dto.AuthenticationRequest;
import com.example.Auth_Service_product.dto.AuthenticationResponse;
import com.example.Auth_Service_product.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest authenticationRequest){
        AuthenticationResponse authenticationResponse = userService.loginUser(authenticationRequest);
        return new ResponseEntity<>(authenticationResponse,HttpStatus.OK);
    }
}

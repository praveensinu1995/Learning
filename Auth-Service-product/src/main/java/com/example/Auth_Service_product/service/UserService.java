package com.example.Auth_Service_product.service;

import com.example.Auth_Service_product.client.UserClient;
import com.example.Auth_Service_product.dto.AuthenticationRequest;
import com.example.Auth_Service_product.dto.AuthenticationResponse;
import com.example.Auth_Service_product.dto.UserResponseDTO;
import com.example.Auth_Service_product.exception.InvaildUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private  static final Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserClient userClient;
    @Autowired
    JwtService jwtService;

    public AuthenticationResponse loginUser(AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        System.out.println(authenticationRequest.getUsername());
        UserResponseDTO userByName = userClient.getUserByName(authenticationRequest.getUsername()).getBody();
        if (userByName != null) {
            boolean validUser = jwtService.validateUser(authenticationRequest.getPassword(), userByName.getPassword());
            if (validUser) {
                authenticationResponse.setToken(jwtService.genrateJwtToken(userByName));
                return authenticationResponse;
            }
        }
        throw new InvaildUserException("username or password dosenot match");

    }
}

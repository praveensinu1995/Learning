package com.example.Auth_Service_product.service;

import com.example.Auth_Service_product.client.UserClient;
import com.example.Auth_Service_product.dto.UserResponseDTO;
import com.example.Auth_Service_product.exception.InvaildUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<UserResponseDTO> userByName = userClient.getUserByName(username);

        if (userByName != null) {
            UserInfoUserDetails userInfoUserDetails = new UserInfoUserDetails(userByName.getBody());
            return userInfoUserDetails;
        }
        throw new InvaildUserException("user not found with provided username :" + userByName);
    }
}

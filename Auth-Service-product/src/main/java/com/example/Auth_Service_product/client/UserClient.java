package com.example.Auth_Service_product.client;

import com.example.Auth_Service_product.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://localhost:8080/api/users")
public interface UserClient {

    @GetMapping("/username/{name}")
    ResponseEntity<UserResponseDTO> getUserByName(@PathVariable String name);
}

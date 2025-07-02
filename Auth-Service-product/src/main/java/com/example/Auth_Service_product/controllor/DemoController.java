package com.example.Auth_Service_product.controllor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hellow");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdmin(){
        return ResponseEntity.ok("getAdmin");
    }
}

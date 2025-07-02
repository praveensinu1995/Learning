package com.example.Auth_Service_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AuthServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceProductApplication.class, args);
	}

}

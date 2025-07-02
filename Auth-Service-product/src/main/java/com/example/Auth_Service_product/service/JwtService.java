package com.example.Auth_Service_product.service;

import com.example.Auth_Service_product.dto.UserResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final BCryptPasswordEncoder passwordEncoder;

    public JwtService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private static Logger LOGGER = LoggerFactory.getLogger(JwtService.class);

    private final String SERCTEKEY = "ertyuhjierdftgyhujerxctybunedretrytyuetryugrtyu";

    public boolean validateUser(String rawPassword, String encoddedPassword) {
        LOGGER.info("inside validateUser to validate user password");
        return passwordEncoder.matches(rawPassword, encoddedPassword);
    }

    public Key getSignKey() {
        byte[] keyBytes = SERCTEKEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String genrateJwtToken(UserResponseDTO userResponseDTO) {
        LOGGER.info("inside genrateJwtToken to the user:{}", userResponseDTO.getUserName());
        Map<String, Object> calims = new HashMap<>();

        calims.put("username", userResponseDTO.getUserName());
        calims.put("roles", userResponseDTO.getRoles());
        return Jwts.builder().setClaims(calims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }

    public Claims extractClams(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
}

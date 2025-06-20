package com.Company.user_service.repository;

import com.Company.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String name);
    Optional<User> findByEmailId(String emailId);
}

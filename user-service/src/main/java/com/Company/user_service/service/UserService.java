package com.Company.user_service.service;

import com.Company.user_service.dto.UserDTO;
import com.Company.user_service.exception.UserNotFoundException;
import com.Company.user_service.model.User;
import com.Company.user_service.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(List.of( "USER"));
        return userRepo.save(user);
    }

    public User findByUserName(String name) {

        return userRepo.findByUserName(name).orElseThrow(()-> new UserNotFoundException("user not found with userName :"+name)) ;
    }

    public User findByEmailID(String emailID) {
        return userRepo.findByEmailId(emailID).orElseThrow(()->new UserNotFoundException("user not found with emailID :"+emailID));
    }
}

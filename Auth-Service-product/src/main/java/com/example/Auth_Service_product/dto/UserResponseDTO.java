package com.example.Auth_Service_product.dto;

import java.util.List;


public class UserResponseDTO {

    private int id;
    private String userName;
    private String emailId;
    private String password;
    private List<String> roles;

    public UserResponseDTO() {
    }

    public UserResponseDTO(List<String> roles, String password, String emailId, String userName, int id) {
        this.roles = roles;
        this.password = password;
        this.emailId = emailId;
        this.userName = userName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

package com.Company.user_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private int id;
    private String userName;
    private String emailId;
    private List<String> roles;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserResponseDTO(int id, String userName, String emailId, List<String> roles) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
        this.roles = roles;
    }
    public UserResponseDTO(){}
}

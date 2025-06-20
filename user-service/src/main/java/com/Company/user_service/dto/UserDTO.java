package com.Company.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "username should not be  null")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" ,message = "Username must not contain special characters")
    private String userName;
    @NotBlank(message = "emailId should not be  null")
    @Email(message = "Email id should be valid")
    private String emailId;
    @NotBlank(message = "password should not be  null")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+=-]).{6,}$",
            message = "Password must contain at least one number, one special character, and be at least 6 characters long"
    )
    private String password;

    public UserDTO(){}

    public UserDTO(String userName, String emailId, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
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
}

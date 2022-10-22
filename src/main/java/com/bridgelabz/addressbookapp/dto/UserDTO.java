package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s?]{2,}$", message = "invalid name! should start with uppercase letter")
    @NotEmpty(message = "username cannot be null")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#@$!%*?&])[A-Za-z\\d#@$!%*?&]{8,}$", message = "password must contain at least one Uppercase letter,one number and a special character")
    private String password;

    @Email(message = "Invalid email! Please enter correct emailId")
    @NotEmpty(message = "email cannot be null")
    private String email;
}

package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z][a-z\\s]{2,}$", message = "firstname is invalid")
    @NotEmpty(message = "first name cannot be null")
    private String firstname;

    @Pattern(regexp = "^[A-Z][a-z\\s]{2,}$", message = "firstname is invalid")
    @NotEmpty(message = "first name cannot be null")
    private String lastname;

    @Email(message = "Email is invalid")
    private String email;

    @Pattern(regexp = "^([0-9]{2,}\\s)?[0-9]{10}$", message = "Phone number is invalid")
    @NotEmpty(message = "Phonenumber cannot be null")
    private String phonenumber;

    @NotEmpty(message = "Address cannot be null")
    private String address;

    @NotEmpty(message = "city cannot be null")
    private String city;

    @NotEmpty(message = "State cannot be null")
    private String state;

//    @Range(min = 6, max = 6, message = "Pincode must be of 6 digits")
    @NotNull(message = "Pincode cannot be null")
    private long pincode;
}

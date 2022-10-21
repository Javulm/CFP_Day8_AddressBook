package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_book")
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String address;
    private String city;
    private String state;
    private long pincode;

public AddressBookData(AddressBookDTO addressBookDTO){
    this.updateAddressBookData(addressBookDTO);
}
public void updateAddressBookData(AddressBookDTO addressBookDTO){
    this.firstname = addressBookDTO.getFirstname();
    this.lastname = addressBookDTO.getLastname();
    this.email = addressBookDTO.getEmail();
    this.phonenumber = addressBookDTO.getPhonenumber();
    this.address = addressBookDTO.getAddress();
    this.city = addressBookDTO.getCity();
    this.state = addressBookDTO.getState();
    this.pincode = addressBookDTO.getPincode();
}
}

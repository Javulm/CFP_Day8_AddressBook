package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.UserDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.model.User;

import java.util.List;

public interface IUserService {

    User userRegistration(UserDTO userDTO);

    List<User> loginUser(String username, String password);

}

package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.UserDTO;
import com.bridgelabz.addressbookapp.exception.UserException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.model.User;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.repository.UserRepository;
import com.bridgelabz.addressbookapp.util.AddressBookUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    private AddressBookUtility addressBookUtility;

    @Override
    public String  userRegistration(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        String token = addressBookUtility.createToken(user.getUserid());
    return token;
    }

    @Override
    public List<User> loginUser(String username, String password) {
        List<User> user = userRepository.userLogin(username, password);
        if (user.isEmpty()) {
            throw new UserException("Either username or password is wrong");
        } else {
            return user;
        }
    }

}

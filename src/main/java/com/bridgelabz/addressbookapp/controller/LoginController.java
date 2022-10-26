package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.dto.UserDTO;
import com.bridgelabz.addressbookapp.model.User;
import com.bridgelabz.addressbookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO> userRegistration(@Valid @RequestBody UserDTO userDTO) {
        String token = userService.userRegistration(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User registration successful.", token);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        List<User> user = userService.loginUser(username, password);
        ResponseDTO responseDTO = new ResponseDTO("Login successfull.", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

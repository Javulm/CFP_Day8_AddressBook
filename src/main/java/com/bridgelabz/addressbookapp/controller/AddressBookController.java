package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping(value = {"", "/", "getall"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@RequestHeader String token) {
        AddressBookData addressBookData = addressBookService.findAddressBookById(token);
        ResponseDTO responseDTO = new ResponseDTO("Get call for id is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyname/{username}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("username") String username) {
        List<AddressBookData> addressBookData = addressBookService.findAddressBookByFirstName(username);
        ResponseDTO responseDTO = new ResponseDTO("Get call for firstname is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbystate/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookDataByState(@PathVariable("state") String state) {
        List<AddressBookData> addressBookData = addressBookService.findAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get call for State is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/add", consumes = {"application/json"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String token = addressBookService.addAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added AddressBook details successfully", token);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestHeader String token, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBookById(token, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook details updated", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestHeader String token){
        addressBookService.deleteAddressBookById(token);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Addressbook data successfully", token);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortAddressBookDataByCity() {
        List<AddressBookData> addressBookData = addressBookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("Get call for sort city is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortAddressBookDataByState() {
        List<AddressBookData> addressBookData = addressBookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("Get call for sort State is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

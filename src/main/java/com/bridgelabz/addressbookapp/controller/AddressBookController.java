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
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int id) {
        AddressBookData addressBookData = addressBookService.findAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call for id is successfull", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyname/{firstname}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("firstname") String firstname) {
        List<AddressBookData> addressBookData = addressBookService.findAddressBookByFirstName(firstname);
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
        AddressBookData addressBookData = addressBookService.addAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added AddressBook details successfully", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("id") int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBookByFirstName(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook details updated", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookdata(@PathVariable("id") int id){
        addressBookService.deleteAddressBookByFirstName(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Addressbook data successfully", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

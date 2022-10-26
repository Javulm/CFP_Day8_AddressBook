package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData findAddressBookById(String token);

    List<AddressBookData> findAddressBookByFirstName(String firstname);

    List<AddressBookData> findAddressBookByState(String state);

    String  addAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookById(String token, AddressBookDTO addressBookDTO);

    void deleteAddressBookById(String token);

    List<AddressBookData> sortAddressBookByCity();

    List<AddressBookData> sortAddressBookByState();
}

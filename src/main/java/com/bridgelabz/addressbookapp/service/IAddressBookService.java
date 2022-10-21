package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();
    AddressBookData findAddressBookById(int id);

    List<AddressBookData> findAddressBookByFirstName(String firstname);
    List<AddressBookData> findAddressBookByState(String state);

    AddressBookData addAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookByFirstName(int id, AddressBookDTO addressBookDTO);

    void deleteAddressBookByFirstName(int id);

}

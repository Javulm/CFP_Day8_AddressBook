package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData findAddressBookById(int id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("AddressBook with Id " + id + "does not exists."));
    }

    @Override
    public List<AddressBookData> findAddressBookByFirstName(String firstname) {
        return addressBookRepository.findAddressBookDataByFirstname(firstname);
    }

    @Override
    public List<AddressBookData> findAddressBookByState(String state) {
        return addressBookRepository.findAddressBookDataByState(state);
    }

    @Override
    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookByFirstName(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.findAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookByFirstName(int id) {
        AddressBookData addressBookData = this.findAddressBookById(id);
        addressBookRepository.delete(addressBookData);
    }
}

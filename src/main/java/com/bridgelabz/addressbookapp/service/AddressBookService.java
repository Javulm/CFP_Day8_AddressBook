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
    public List<AddressBookData> findAddressBookByFirstName(String username) {
        List<AddressBookData> addressBookDataList = addressBookRepository.getAddressBookDataByUsername(username);
        if (addressBookDataList.isEmpty()) {
            throw new AddressBookException("AddressBookData with firstname " + username + "does not exist");
        }
        return addressBookDataList;
    }

    @Override
    public List<AddressBookData> findAddressBookByState(String state) {
        List<AddressBookData> addressBookDataList = addressBookRepository.findAddressBookDataByState(state);
        if (addressBookDataList.isEmpty()) {
            throw new AddressBookException("AddressBookData with state " + state + "does not exist");
        }
        return addressBookDataList;
    }

    @Override
    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookById(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.findAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookById(int id) {
        AddressBookData addressBookData = this.findAddressBookById(id);
        addressBookRepository.delete(addressBookData);
    }

    @Override
    public List<AddressBookData> sortAddressBookByCity() {
        return addressBookRepository.sortAddressBookByCity();
    }

    @Override
    public List<AddressBookData> sortAddressBookByState() {
        return addressBookRepository.sortAddressBookByState();
    }
}

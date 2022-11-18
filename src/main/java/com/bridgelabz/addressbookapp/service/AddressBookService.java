package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.util.AddressBookUtility;
import com.bridgelabz.addressbookapp.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private AddressBookUtility addressBookUtility;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData findAddressBookById(int id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("AddressBook with Id " + id + "does not exists."));
    }

    @Override
    public AddressBookData findAddressBookByToken(String token) {
        int Id = addressBookUtility.decodeJWT(token);
        return addressBookRepository.findById(Id).orElseThrow(() -> new AddressBookException("AddressBook with Id " + Id + "does not exists."));
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
    public String addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        addressBookRepository.save(addressBookData);
        emailSender.sendEmail(addressBookData.getEmail(), "test Email", "Data added successfully");
        return addressBookUtility.createToken(addressBookData.getId());
    }

    @Override
    public AddressBookData updateAddressBookById(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.findAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        emailSender.sendEmail(addressBookData.getEmail(), "test Email", "Data updated successfully");
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

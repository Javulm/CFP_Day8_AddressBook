package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

    @Query(value = "select * from address_book where firstname= :username", nativeQuery = true)
    List<AddressBookData> getAddressBookDataByUsername(String username);

    @Query(value = "select * from address_book where state = :state", nativeQuery = true)
    List<AddressBookData> findAddressBookDataByState(String state);

    @Query(value = "select * from address_book order by city",nativeQuery = true)
    List<AddressBookData> sortAddressBookByCity();
    @Query(value = "select * from address_book order by state",nativeQuery = true)
    List<AddressBookData> sortAddressBookByState();
}

package com.cg.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.addressbookapp.models.AddressBookData;

public interface IAddressBookRespository extends JpaRepository<AddressBookData, Long> {

}

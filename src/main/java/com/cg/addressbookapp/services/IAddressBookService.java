package com.cg.addressbookapp.services;

import java.util.List;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.exception.AddressBookException;
import com.cg.addressbookapp.models.AddressBookData;
import com.google.common.base.Optional;

public interface IAddressBookService {

	public AddressBookData addPerson(AddressBookDTO addressBookDTO);

	AddressBookData getPersonById(Long id) throws AddressBookException;

	public List<AddressBookData> getAllAddressBookData();

	public List<AddressBookData> getPersonByCity(String city);
}

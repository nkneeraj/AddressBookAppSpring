package com.cg.addressbookapp.services;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.models.AddressBookData;

public interface IAddressBookService {

	public AddressBookData addPerson(AddressBookDTO addressBookDTO);
}

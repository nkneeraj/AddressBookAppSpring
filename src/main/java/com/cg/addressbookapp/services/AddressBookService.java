package com.cg.addressbookapp.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.models.AddressBookData;
import com.cg.addressbookapp.repository.IAddressBookRespository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRespository addressBookRepository;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public AddressBookData addPerson(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = mapper.map(addressBookDTO, AddressBookData.class);
		return addressBookRepository.save(addressBookData);
	}

}

package com.cg.addressbookapp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.exception.AddressBookException;
import com.cg.addressbookapp.models.AddressBookData;
import com.cg.addressbookapp.repository.IAddressBookRespository;
import com.google.common.base.Optional;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRespository addressBookRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 *@param addressBookDTO
	 *@return {@link AddressBookData}
	 */
	@Override
	public AddressBookData addPerson(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = modelMapper.map(addressBookDTO, AddressBookData.class);
		return addressBookRepository.save(addressBookData);
	}
	
	/**
	 * @param id
	 * @return {@link AddressBookData}
	 * @throws AddressBookException
	 *
	 */
	@Override
	public AddressBookData getPersonById(Long id) throws AddressBookException {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("Invalid Person id"));
	}

	/**
	 *@return {@link AddressBookData}
	 */
	@Override
	public List<AddressBookData> getAllAddressBookData() {
		return addressBookRepository.findAll();
	}

	/**
	 *@param city
	 *@return {@link AddressBookData}
	 */
	@Override
	public List<AddressBookData> getPersonByCity(String city) {
		List<AddressBookData> dataList = addressBookRepository.findBycity(city);
		System.out.println(dataList);
		return dataList;
//		return List<AddressBookData> addressBookRepository.findBycity(city);
	}

	/**
	 *@return {@link AddressBookDTO}
	 *throws AddressBookException
	 */
	@Override
	public AddressBookData deletePersonById(long id) throws AddressBookException {
		AddressBookData addressBookData = getPersonById(id);
		addressBookRepository.deleteById(id);
		return addressBookData;
	}
	
	/**
	 *@param id
	 *@return {@link AddressBookData}
	 *throws AddressBookException
	 */
	@Override
	public AddressBookData updatePersonById(long id, AddressBookDTO addressBookDTO) throws AddressBookException {
		AddressBookData addressBookData = getPersonById(id);
		modelMapper.map(addressBookDTO, addressBookData);
		return addressBookRepository.save(getPersonById(id));
	}
}

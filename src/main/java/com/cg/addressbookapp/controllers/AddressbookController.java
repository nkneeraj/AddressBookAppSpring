package com.cg.addressbookapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.addressbookdto.ResponseDTO;
import com.cg.addressbookapp.exception.AddressBookException;
import com.cg.addressbookapp.models.AddressBookData;
import com.cg.addressbookapp.services.IAddressBookService;
import com.google.common.base.Optional;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/addressbook")
public class AddressbookController {

	@Autowired
	private IAddressBookService addressBookService;

	/**
	 * Post API: Add Person data to database.
	 * @param addressBookDTO
	 * @return
	 */
	@ApiOperation(value = "This API is used to add new person data to address book")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData = addressBookService.addPerson(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Person data added successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}
	
	/**Get API: Fetch Person data be PersonId.
	 * @param id
	 * @return
	 * @throws AddressBookException
	 */
	@ApiOperation(value = "This API is used to fetch person address by id" , notes = "Enter Person Id", response = AddressBookData.class)
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable Long id) throws AddressBookException{
		AddressBookData addressBookData = addressBookService.getPersonById(id);
		ResponseDTO responseDTO = new ResponseDTO("Person Data Fetched Successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}	
	
	/**
	 * Get API: Fetch all Person data from database.
	 * @return
	 */
	@ApiOperation(value = "This API is used to fetch all persons data.")
	@GetMapping(value = {"/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressDataList = addressBookService.getAllAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("All Person Data Fetched Successfully", addressDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	/**
	 * Get API: Fetch persons data by city name."
	 * @param city
	 * @return
	 * @throws AddressBookException
	 */
	@ApiOperation(value = "This API is used to fetch persons data by city.")
	@GetMapping("/getDataByCity")
	public ResponseEntity<ResponseDTO> getAddressBookData1(@RequestParam String city) throws AddressBookException{
		List<AddressBookData> addressBookData = addressBookService.getPersonByCity(city);
		ResponseDTO responseDTO = new ResponseDTO("Person Data Fetched Successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws AddressBookException
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "This API is used to delete persons data by id.")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable long id) throws AddressBookException {
		AddressBookData addressBookData = addressBookService.deletePersonById(id);
		ResponseDTO responseDTO = new ResponseDTO("Person Data deleted Successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}	
	
	/**
	 * Put API: used to update person data be id
	 * @param id
	 * @param addressBookDTO
	 * @return
	 * @throws AddressBookException
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "This API is used to update person data.")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable long id, @RequestBody AddressBookDTO addressBookDTO) throws AddressBookException {
		AddressBookData addressBookData = addressBookService.updatePersonById(id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Person Data updated Successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}

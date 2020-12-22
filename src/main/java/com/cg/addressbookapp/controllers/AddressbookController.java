package com.cg.addressbookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.addressbookapp.addressbookdto.AddressBookDTO;
import com.cg.addressbookapp.addressbookdto.ResponseDTO;
import com.cg.addressbookapp.models.AddressBookData;
import com.cg.addressbookapp.services.IAddressBookService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/addressbook")
public class AddressbookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@ApiOperation(value = "This API is used to add new person data to address book")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData = addressBookService.addPerson(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}
	
}

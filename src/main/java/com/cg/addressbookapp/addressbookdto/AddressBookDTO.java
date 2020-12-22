package com.cg.addressbookapp.addressbookdto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDTO {
	
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}( [A-Z]{1}[a-zA-Z]{2,})*$", message = "Invalid Name")
	public String fullName;
	
	@Pattern(regexp = "^[a-zA-Z0-9-, ]+", message= "Invalid address")
	public String address;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message= "Invalid city")
	public String city;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message= "Invalid state")
	public String state;
	
	@Pattern(regexp = "^[0-9]{2,}", message = "Invalid zip number")
	public String zipCode;
	
	@Pattern(regexp = "^[0-9]{1,}[ ][1-9][0-9]{9}$", message = "Invalid phone number")
	public String phoneNumber;

}

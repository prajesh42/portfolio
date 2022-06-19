package com.portfolio.model;

import com.portfolio.dto.AddressDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	private Integer id;
	private String addressLocation;
	private String street1;
	private String street2;
	private String pinCode;
	private String country;
	
	public AddressDTO mapAddress() {
		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setId(id);
		addressDTO.setAddressLocation(addressLocation);
		addressDTO.setStreet1(street1);
		addressDTO.setStreet2(street2);
		addressDTO.setPinCode(pinCode);
		addressDTO.setCountry(country);
		return addressDTO;
	}
}

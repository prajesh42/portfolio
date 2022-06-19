package com.portfolio.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.portfolio.model.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PROFILE_ADDRESS")
@Entity
public class AddressDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String addressLocation;
	private String street1;
	private String street2;
	private String pinCode;
	private String country;
	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
	private ProfileDTO profile;
	
	public Address mapAddressDTO() {
		Address address=new Address();
		address.setId(id);
		address.setAddressLocation(addressLocation);
		address.setStreet1(street1);
		address.setStreet2(street2);
		address.setPinCode(pinCode);
		address.setCountry(country);
		return address;
	}
}

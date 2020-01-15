package com.app.dto;

import java.util.List;

public class CustomerDto {

	private int id;
	private String name;
	private List<AddressDto> addressesDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddressDto> getAddressesDto() {
		return addressesDto;
	}

	public void setAddressesDto(List<AddressDto> addressesDto) {
		this.addressesDto = addressesDto;
	}
}

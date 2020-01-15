package com.app.transformer;

import com.app.dto.AddressDto;
import com.app.entity.AddressEntity;

public class AddressTransformer {

	public static AddressEntity dtoToEntity(AddressDto addressDto) {
		AddressEntity addressEntity = new AddressEntity();
		if (addressDto.getId() != 0)
			addressEntity.setId(addressDto.getId());
		addressEntity.setStreet(addressDto.getStreet());
		addressEntity.setLandmark(addressDto.getLandmark());
		addressEntity.setCity(addressDto.getCity());
		return addressEntity;
	}

	public static AddressDto entitytoDto(AddressEntity addressEntity) {
		AddressDto addressDto = new AddressDto();
		if (addressEntity.getId() != 0)
			addressDto.setId(addressEntity.getId());
		addressDto.setStreet(addressEntity.getStreet());
		addressDto.setLandmark(addressEntity.getLandmark());
		addressDto.setCity(addressEntity.getCity());
		return addressDto;
	}
}

package com.app.transformer;

import com.app.dto.CustomerDto;
import com.app.entity.CustomerEntity;

public class CustomerTransformer {

	public static CustomerEntity dtoToEntity(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity();
		if (customerDto.getId() != 0)
			customerEntity.setId(customerDto.getId());
		customerEntity.setName(customerDto.getName());
		return customerEntity;
	}

	public static CustomerDto enityToDto(CustomerEntity customerEntity) {
		CustomerDto customerDto = new CustomerDto();
		if (customerEntity.getId() != 0)
			customerDto.setId(customerEntity.getId());
		customerDto.setName(customerEntity.getName());
		return customerDto;
	}

}

package com.app.serive.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AddressDto;
import com.app.dto.CustomerDto;
import com.app.entity.AddressEntity;
import com.app.entity.CustomerEntity;
import com.app.repo.api.CustomerRepository;
import com.app.serive.api.CustomerService;
import com.app.transformer.AddressTransformer;
import com.app.transformer.CustomerTransformer;

@Service
public class CustomerSeriveImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public void saveCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = CustomerTransformer.dtoToEntity(customerDto);

		List<AddressEntity> addressEntityList = new ArrayList<AddressEntity>();
		for (AddressDto addressDto : customerDto.getAddressesDto()) {
			AddressEntity addressEntity = AddressTransformer.dtoToEntity(addressDto);
			addressEntity.setCustomer(customerEntity);
			addressEntityList.add(addressEntity);
		}
		customerEntity.setAddresses(addressEntityList);
		customerRepository.saveCustomer(customerEntity);
	}

	public List<CustomerDto> getCustomers() {
		List<CustomerEntity> customerEntityList = customerRepository.getCustomers();
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();

		for (CustomerEntity customerEntity : customerEntityList) {
			CustomerDto customerDto = CustomerTransformer.enityToDto(customerEntity);
			List<AddressDto> addressesDtoList = new ArrayList<AddressDto>();
			for (AddressEntity addressEntity : customerEntity.getAddresses()) {
				AddressDto addressDto = AddressTransformer.entitytoDto(addressEntity);
				addressDto.setCustomerDto(customerDto);
				addressesDtoList.add(addressDto);
			}
			customerDto.setAddressesDto(addressesDtoList);
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
	}

}

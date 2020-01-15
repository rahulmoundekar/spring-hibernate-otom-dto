package com.app.serive.api;

import java.util.List;

import com.app.dto.CustomerDto;

public interface CustomerService {

	public void saveCustomer(CustomerDto customerDto);
	public List<CustomerDto> getCustomers();

}

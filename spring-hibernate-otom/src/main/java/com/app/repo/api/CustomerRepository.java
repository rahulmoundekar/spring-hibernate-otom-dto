package com.app.repo.api;

import java.util.List;

import com.app.dto.CustomerDto;
import com.app.entity.CustomerEntity;

public interface CustomerRepository {

	public void saveCustomer(CustomerEntity customerEntity);
	public List<CustomerEntity> getCustomers();

}

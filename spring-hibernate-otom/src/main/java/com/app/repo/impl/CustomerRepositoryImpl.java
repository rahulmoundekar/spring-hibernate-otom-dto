package com.app.repo.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.CustomerEntity;
import com.app.repo.api.CustomerRepository;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	SessionFactory sessionFactory;

	public void saveCustomer(CustomerEntity customerEntity) {
		sessionFactory.openSession().save(customerEntity);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerEntity> getCustomers() {
		return sessionFactory.openSession().createCriteria(CustomerEntity.class).list();
	}

}

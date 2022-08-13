package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.exceptions.NotFoundException;
import com.masai.model.Customer;

@Service
public interface CustomerServiceIntr {
	
  public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, String key) throws NotFoundException;
	
	public Customer deleteCustomer(String key) throws NotFoundException;
	
	public Customer getCustomerDetails(String key) throws NotFoundException;
	
	
}

package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.services.CustomerServiceIntr;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceIntr customerServiceImpl;

		// to register user
		@PostMapping(value = "/customer")
		public Customer saveCustomer(@Valid @RequestBody Customer customer) {
			return customerServiceImpl.createCustomer(customer);
		}
		
		// To update existing user details by passing its login key
		@PutMapping(value = "/customer")
		public Customer updateCustomer(@Valid @RequestBody Customer customer, @RequestParam(required = false) String key) {
			return customerServiceImpl.updateCustomer(customer, key);
		}
		
		// To delete existing user details by passing its login key
		@DeleteMapping(value = "/customer")
		public Customer deleteCustomer(@RequestParam(required = false) String key) {
			return customerServiceImpl.deleteCustomer(key);
		}
		
		// To get details of current user by passing its login key
		@GetMapping(value = "/customer")
		public Customer getCustomerDetails(@RequestParam(required = false) String key) {
			return customerServiceImpl.getCustomerDetails(key);
		}
	

}

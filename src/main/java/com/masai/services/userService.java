package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;

@Service
public interface userService {

	public Customer validateUser(String mobileNumber,String password) throws InvalidAccountException;
}

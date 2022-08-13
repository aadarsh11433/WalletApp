package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;

@Service
public class userServiceImpl implements userService {
	
	
	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer validateUser(String mobileNumber, String password) throws InvalidAccountException {
		
		Optional<Customer> optCustomer = cDao.findByMobileNumber(mobileNumber);
		
		if(!optCustomer.isPresent()) {
			
			throw new InvalidAccountException("Customer Not Found");
		}
		
		if(!optCustomer.get().getPassword().equals(password)) {
			throw new InvalidAccountException("Invalid Password");
		}
		
		return optCustomer.get();
	}

}

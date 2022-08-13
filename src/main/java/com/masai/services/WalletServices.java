package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.model.Customer;

@Service
public interface WalletServices {
	
   public Customer createAccount(Customer customer); // name,mobilino,balance,password
   
   
}

package com.masai.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;

@Service
public interface WalletServices {
	
   public Customer createAccount(Customer customer); // name,mobilino,balance,password
   

   public BigDecimal showBalance(String mobileNo) throws InvalidAccountException;

}

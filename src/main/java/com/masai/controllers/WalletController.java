package com.masai.controllers;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;

import com.masai.services.WalletServices;


@RestController
public class WalletController {
   
  @Autowired
  private WalletServices wService;
	
	@PostMapping("/createaccount")
	public Customer createAccountHandler(@RequestBody Customer customer) {
		
		return wService.createAccount(customer);
		
	}
	
   
	@GetMapping("/balance/{mobileNumber}")
	public BigDecimal showBalanceHandler(@PathVariable("mobileNumber") String mobileNumber) throws InvalidAccountException {
		return wService.showBalance(mobileNumber);
	}
	
}

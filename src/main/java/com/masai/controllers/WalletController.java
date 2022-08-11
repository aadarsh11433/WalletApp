package com.masai.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

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
}

package com.masai.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;

import com.masai.services.WalletServices;
import com.masai.services.userService;


@RestController
public class WalletController {
   
  @Autowired
  private WalletServices wService;
  
  @Autowired
  private userService uServise;
	
	@PostMapping("/createaccount")
	public Customer createAccountHandler(@RequestBody Customer customer) {
		
		return wService.createAccount(customer);
		
	}
	
   
	@GetMapping("/validate/{mobileNumber}/{password}")
	public Customer showBalanceHandler(@PathVariable("mobileNumber") String mobileNumber,
										@PathVariable("password") String password) throws InvalidAccountException {
		return uServise.validateUser(mobileNumber, password);
	}
	
}

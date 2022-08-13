package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.BankAccount;
import com.masai.services.AccountServices;

@RestController
public class AccountController {

	
	@Autowired
	AccountServices accService;
	
	
	@GetMapping("/accounts/{mobileNumber}/{password}")
	public List<BankAccount> findAllBankAccounts(@PathVariable("mobileNumber") String mobileNumber,@PathVariable("password") String password) throws InvalidAccountException{
		
		return accService.viewAccounts(mobileNumber, password);
		
	}
	
	
	@PostMapping("/accounts/{mobileNumber}/{password}")
	public BankAccount addBankAccount(@PathVariable("mobileNumber") String mobile,
										@PathVariable("password") String password,
										@RequestBody BankAccount bank) throws InvalidAccountException {
		
		return accService.addAccount(mobile, password, bank);
	}
	
	@DeleteMapping("/accounts/{mobileNumber}/{password}")
	public BankAccount removeBankAccount(@PathVariable("mobileNumber") String mobile,
										@PathVariable("password") String password,
										@RequestBody BankAccount bank) throws InvalidAccountException {
		
		return accService.removeBankAccount(mobile, password, bank);
	}
	
}

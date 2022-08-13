package com.masai.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.services.TransactionSevices;
import com.masai.services.WalletServices;
import com.masai.services.userService;


@RestController
public class WalletController {
   
  @Autowired
  private WalletServices wService;
  
  @Autowired
  private TransactionSevices transactionServices;

  @Autowired
  private userService uServise;

	
	@PostMapping("/createaccount")
	public Customer createAccountHandler(@RequestBody Customer customer) {
		
		return wService.createAccount(customer);
		
	}
	

	@GetMapping("/alltransactions")
	public List<Transaction> allTransationsHandler(@RequestBody Wallet wallet) {
		
	
	       return transactionServices.viewAllTransaction(wallet);
		
	}
	
	@PostMapping("/addtransactions")
	public Transaction addTransationHandler(@RequestBody Transaction trnasaction) {
		
	
	      return transactionServices.addTransaction(trnasaction);
		
	}

   
	@GetMapping("/validate/{mobileNumber}/{password}")
	public Customer showBalanceHandler(@PathVariable("mobileNumber") String mobileNumber,
										@PathVariable("password") String password) throws InvalidAccountException {
		return uServise.validateUser(mobileNumber, password);
	}
	

}

package com.masai.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.WalletException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.services.UserService;
import com.masai.services.WalletServices;


@RestController
public class WalletController {
   
  @Autowired
  private WalletServices wService;
  
  @Autowired
  private UserService uService;
  
  
  
  
  
	
	@PostMapping("/createaccount")
	public BankAccount createAccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {
		
		return wService.createAccount(bank, key);
		
	}
	
   
//	@GetMapping("/balance/{mobileNumber}")
//	public double showBalanceHandler(@PathVariable("mobileNumber") String mobileNumber) throws InvalidAccountException {
//		return wService.showBalance(mobileNumber);
//	}
//	
//   // validate login
//	
//	@GetMapping("/validate/{mobileNumber}/{password}")
//	public Customer validateLoginHandler(@PathVariable("mobileNumber") String mobileNumber, @PathVariable("password") String password) throws InvalidAccountException {
//		return uService.validLogin(mobileNumber, password);
//	}
//	
//	@PutMapping("/walletfundtransfer/{sourceMobile}/{targeMobile}/{amount}")
//	public String fundTransferHandler(@PathVariable String sourceMobile,@PathVariable String targeMobile,@PathVariable double amount) throws WalletException {
//		wService.FundTransfer(sourceMobile, targeMobile, amount);
//		return amount + " Transaction successfull";
//	}
//	
//	@PutMapping("/deposit/{mobileNumber}/{bankName}/{amount}")
//	public Customer depositToBank(@PathVariable String mobileNumber,@PathVariable String bankName, @PathVariable double amount) {
//		
//		return wService.depositAmount(mobileNumber, bankName, amount);
//	}
//	
//	//customer
//	
//	@GetMapping("/customerlist")
//	public List<Customer> customerListsHandler(){
//		 return uService.getList();
//	}
//	
//	
//	
//	@PutMapping("/updatecustomer")
//	public Customer updateCustomer(@RequestBody Customer customer) {
//		return uService.updateCustomer(customer);
//		
//	}
//	
//	
//	@PutMapping("/addmoney/{walletid}/{bankName}/{amount}")
//	public Customer addMoneyToWalletHandler(@PathVariable Integer walletid,@PathVariable String bankName,@PathVariable double amount) {
//		
//		return wService.addMoneytoWallet(walletid, bankName, amount);
//	}
	
	
}

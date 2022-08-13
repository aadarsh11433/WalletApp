package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;

@Service
public interface WalletServices {
	
  // public Customer createAccount(Customer customer); // name,mobilino,balance,password
   
  
	public BankAccount createAccount(BankAccount bank, String key);
 
   public void FundTransfer(String sourceMobileNo, String targetMobileNo,double amount) throws InsufficientAmountException;

   
    public double showWalletBalance(String key) throws NotFoundException;
    
//    public double showBankBalance(String key) throws NotFoundException;
    
    
   
   public Customer depositAmount(double amount ,String key) throws InsufficientAmountException;
 
   
   public String addMoneyToWallet(double amount,String key) throws InsufficientAmountException;
   
   
   
}

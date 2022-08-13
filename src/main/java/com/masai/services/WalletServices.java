package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;
import com.masai.model.Wallet;

@Service
public interface WalletServices {
	
   public Customer createAccount(Customer customer); // name,mobilino,balance,password
   
   public double showBalance(String mobileNo) throws InvalidAccountException;
 
   public void FundTransfer(String sourceMobileNo, String targetMobileNo,double amount);

   public Customer depositAmount(String mobileNumber,String bankName,double amount);
  
   public Customer addMoneytoWallet(Integer walletid ,String bankName,double amount);
   
   
}

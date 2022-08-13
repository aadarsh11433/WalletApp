package com.masai.services;

import java.util.List;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.BankAccount;

public interface AccountServices {

	public List<BankAccount> viewAccounts(String mobileNumber,String password) throws InvalidAccountException;
	
	public BankAccount addAccount(String mobileNumber,String password,BankAccount bank) throws InvalidAccountException;
	
	public BankAccount removeBankAccount(String mobileNumber,String password,BankAccount bank) throws InvalidAccountException;
}

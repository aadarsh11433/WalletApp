package com.masai.services;

import java.util.List;

import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface TransactionSevices {

	public List<Transaction> viewAllTransaction(Wallet wallet);
	
	public Transaction addTransaction (Transaction trans);
}

package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Transaction;
import com.masai.model.Wallet; 
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;


@Service
public class TransactionServiceImpl implements TransactionSevices {

	@Autowired
	WalletDao wDao;
	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public List<Transaction> viewAllTransaction(Wallet wallet) {
		
		
		List <Transaction>  transactionList = wallet.getTransactions();
		
		return transactionList;
	}

	@Override
	public Transaction addTransaction(Transaction trans) {
		
		Wallet wallet = trans.getWallet();
		wallet.getTransactions().add(trans);
		
		wDao.save(wallet);
		return transactionDao.save(trans);
	
	}

}

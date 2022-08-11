package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.WalletDao;

@Service
public class WalletServiceImpl implements WalletServices{
     
	@Autowired
	WalletDao wDao;
	@Autowired
	CustomerDao cDao;
	@Autowired
	BankAccountDao bDao;
	
	
	@Override
	public Customer createAccount(Customer customer) {
	     
		Wallet saveWallet = customer.getWallet();
		
	
		
	   List<BankAccount> listbanks = saveWallet.getBankaccounts();
		
	   for(BankAccount bac:listbanks) {
		    saveWallet.getBankaccounts().add(bac);
		    bDao.save(bac);
	   }
	
	    wDao.save(saveWallet);
		
		return cDao.save(customer);
		
	}

}

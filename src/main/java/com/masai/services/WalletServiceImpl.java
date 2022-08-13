package com.masai.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.exceptions.WalletException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.WalletDao;
import com.masai.util.GetCurrentLoginUserSessionDetailsImpl;
import com.masai.util.GetCurrentLoginUserSessionDetailsIntr;

@Service
public class WalletServiceImpl implements WalletServices{
     
	@Autowired
	WalletDao wDao;
	@Autowired
	CustomerDao cDao;
	@Autowired
	BankAccountDao bDao;
	
	@Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

	@Override
	public void FundTransfer(String sourceMobileNo, String targetMobileNo, double amount)
			throws InsufficientAmountException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double showWalletBalance(String key) throws NotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer depositAmount(double amount, String key) throws InsufficientAmountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMoneyToWallet(double amount, String key) throws InsufficientAmountException {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount createAccount(BankAccount bank, String key) {
		
	  Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);
	  
	   wallet.getBankaccounts().add(bank);
	   
	    wDao.save(wallet);
	    
	    bank.setWallet(wallet);
		bDao.save(bank);
		
		return bank;
	}
	
	

	
}



package com.masai.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
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
		
	
		
//	   List<BankAccount> listbanks = saveWallet.getBankaccounts();
//		
//	   for(BankAccount bac:listbanks) {
//		    saveWallet.getBankaccounts().add(bac);
//		    bDao.save(bac);
//	   }
	
	    wDao.save(saveWallet);
		
		return cDao.save(customer);
		
	}


	@Override
	public BigDecimal showBalance(String mobileNo) throws InvalidAccountException {

	  Optional<Customer> otp =cDao.findByMobileNumber(mobileNo);
	  if(!otp.isPresent()) {
		  throw new InvalidAccountException("Account not found");
	  }else {
		  return otp.get().getWallet().getBalance();
	  }
		
		
		
	}

}

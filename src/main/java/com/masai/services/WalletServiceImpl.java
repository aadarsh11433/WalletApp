package com.masai.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.WalletException;
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
	
	
//	
//	@Override
//	public Customer createAccount(Customer customer) {
//	     
//		
//		//check wallet exist or not
//		
//		Wallet saveWallet = customer.getWallet();
//	
//	
//	    wDao.save(saveWallet);
//		
//		return cDao.save(customer);
//		
//	}

  
	@Override
	public double showBalance(String mobileNo) throws InvalidAccountException {

		
	  Optional<Customer> otp =cDao.findByMobileNumber(mobileNo);
	  
	  if(!otp.isPresent()) {
		  throw new InvalidAccountException("Account not found");
	  }else {
		  return otp.get().getWallet().getBalance();
	  }
		
		
		
	}

  //TODO
	@Override
	public void FundTransfer(String sourceMobileNo, String targetMobileNo, double amount){
		// TODO Auto-generated method stub		
	   Optional<Customer> optSourceCustomer =  cDao.findByMobileNumber(sourceMobileNo);

	   Optional<Customer> optTargetCustomer =  cDao.findByMobileNumber(targetMobileNo);
	   
	   if(!optSourceCustomer.isPresent()) {
		   throw new InvalidAccountException("Source customer not found");
		
	   }
	   
	   if(!optTargetCustomer.isPresent()) {
		   throw new InvalidAccountException("Target customer not found"); 
	   }
	  Customer sm = optSourceCustomer.get();
	  Customer tm = optTargetCustomer.get();

	  
	  double sourceBalance = sm.getWallet().getBalance();

	  if(sourceBalance < amount) {
		  throw new WalletException("Insufficient wallet balance");
	  }
	 sm.getWallet().setBalance(sm.getWallet().getBalance() - amount);
	 tm.getWallet().setBalance(tm.getWallet().getBalance() + amount);
	   
	 cDao.save(sm);
	 cDao.save(tm);
	 
	 
	}


	@Override
	public Customer depositAmount(String mobileNumber,String bankName, double amount) {
		// TODO Auto-generated method stub
		
		  Optional<Customer> existingCustomer = cDao.findByMobileNumber(mobileNumber);
		  if(!existingCustomer.isPresent()) {
			  throw new InvalidAccountException("Account does not exist..");
		  }
		  
		  List<BankAccount> listBanks =  existingCustomer.get().getWallet().getBankaccounts();
		  BankAccount b = null;
		  
		  for(BankAccount bank :listBanks) {
			 if( bank.getBankname().equals(bankName)) {
				b=bank;
			 }
		  }
		  
		  b.setBalance(b.getBalance()+ amount);
		  bDao.save(b);
		 
		return existingCustomer.get();
	}


	@Override
	public Customer addMoneytoWallet(Integer walletid,String bankName, double amount) {
		// TODO Auto-generated method stub
		
		Optional<Wallet> existingWallet = wDao.findById(walletid);
		
		 List<BankAccount> blist = existingWallet.get().getBankaccounts();
		 
		 BankAccount b = null;
		 
		 for(BankAccount bank  :blist) {
			 if(bank.getBankname().equals(bankName)){
				 b = bank;
			 }
		 }
		 b.setBalance(b.getBalance() - amount);
		 
		 Wallet w = existingWallet.get();			
			bDao.save(b); 
		 w.setBalance(w.getBalance()+amount);
		  wDao.save(w);
		  return w.getCustomer();
	}
}



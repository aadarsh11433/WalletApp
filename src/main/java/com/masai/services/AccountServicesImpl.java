package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidAccountException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.WalletDao;

@Service
public class AccountServicesImpl implements AccountServices {
	
	@Autowired
	userService uService;
	
	@Autowired
	WalletServiceImpl wService;
	
	@Autowired
	BankAccountDao accDao;
	
	

	@Override
	public List<BankAccount> viewAccounts(String mobileNumber, String password) throws InvalidAccountException {
		
		Optional<Customer> optCustomer =  Optional.ofNullable(uService.validateUser(mobileNumber, password));
		
		List<BankAccount> bankaccounts = optCustomer.get().getWallet().getBankaccounts();
		
		
		return bankaccounts;
	}




	@Override
	public BankAccount addAccount(String mobileNumber, String password,BankAccount bank) throws InvalidAccountException {
		
		Optional<Customer> optCustomer =  Optional.ofNullable(uService.validateUser(mobileNumber, password));
		
		
		Customer customer = optCustomer.get();
		
		customer.getWallet().getBankaccounts().add(bank);
		
		wService.createAccount(customer);	
		
//		accDao.save(bank);
//		wDao.save(customer.getWallet());
//		cDao.save(customer);
				
		return bank;
	}





	
	
	
	@Override
	public BankAccount removeBankAccount(String mobileNumber, String password, BankAccount bank)
			throws InvalidAccountException {
		
		Optional<Customer> optCustomer =  Optional.ofNullable(uService.validateUser(mobileNumber, password));
		
		optCustomer.get().getWallet().getBankaccounts().remove(bank);
		
		wService.createAccount(optCustomer.get());
		
		
		return bank;
	}
	
	
	
	
	
	

}

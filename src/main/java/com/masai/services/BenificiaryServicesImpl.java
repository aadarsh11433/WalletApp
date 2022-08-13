package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Benificiary;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;

@Service
public class BenificiaryServicesImpl implements BenificiaryServices{

	
	@Autowired
	private CustomerDao cDao;
	
	@Override
	public Benificiary addBenificiary(Benificiary benificiary) throws Exception {
		
		// whoever is login --> add wbenifiacary to that wallet
		
		return null;
	}

	@Override
	public Benificiary deleteBenificiary(Benificiary benificiary) throws Exception {
		// whoever is login --> delete  wbenifiacary to that wallet
		//.wallet.getbenifi...  == list find this benificiary and delete
		return null;
	}

	@Override
	public Benificiary viewBenificiaryDetails(String mobileNumber) throws Exception {
		
	    Optional<Customer> optCustomer = 	cDao.findByMobileNumber(mobileNumber);
	    
	   
	    if (optCustomer.isPresent()) {
	    	List<Benificiary> list  = optCustomer.get().getWallet().getBenificiaries();
	    	
	    	for(Benificiary ben :list) {
	    		if(ben.getMobileNumber().equals(mobileNumber))
	    			return ben;
	    	}
	    }
	    else 
	    	throw new Exception();
		 
	    return null;
	}

	@Override
	public List<Benificiary> viewAllBenificiary(Customer customer) throws Exception {
		
		List<Benificiary> list = customer.getWallet().getBenificiaries();
		
		return list;
	}

}

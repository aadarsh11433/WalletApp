package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Benificiary;
import com.masai.model.Customer;


@Service
public interface BenificiaryServices {

	public Benificiary addBenificiary(Benificiary benificiary) throws Exception;
	
	public Benificiary deleteBenificiary(Benificiary benificiary) throws Exception;
	
	public Benificiary viewBenificiaryDetails(String mobileNumber) throws Exception;
	
	public List<Benificiary> viewAllBenificiary(Customer customer) throws Exception;
	
	
}

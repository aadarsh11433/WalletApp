package com.masai.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.NotFoundException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsIntr{
   
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws NotFoundException {
		// TODO Auto-generated method stub
		
	  Optional<CurrentUserSession>	optCurrSession = sessionDao.findByUuid(key);
	  
	  if(!optCurrSession.isPresent()) {
		  throw new NotFoundException("You are not authorized user");
	  }
	
		
		return optCurrSession.get();
	}

	@Override
	public Customer getCurrentCustomer(String key) throws NotFoundException {
		
     Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("Unauthorized");
		}
		
		
	Integer customerId =	optional.get().getCustomerId();
	return customerDao.getById(customerId);
		
//		CurrentUserSession cs= optional.get();
//		Optional<Customer> c = customerDao.findById(cs.getCustomerId());
//		Customer cc =c.get();
//		
//		return  cc;
		
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws NotFoundException {
    Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("Unauthorized");
		}
		
		return optional.get().getId();
	}

}

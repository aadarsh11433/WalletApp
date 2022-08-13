package com.masai.util;



import com.masai.exceptions.NotFoundException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;

public interface GetCurrentLoginUserSessionDetailsIntr {
	
    public CurrentUserSession getCurrentUserSession(String key) throws NotFoundException;
    
    public Customer getCurrentCustomer(String key) throws NotFoundException;
    
    public Integer getCurrentUserSessionId(String key) throws NotFoundException;
	
}

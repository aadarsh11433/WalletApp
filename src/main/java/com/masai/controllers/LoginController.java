package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.LoginDTO;

import com.masai.services.CustomerLoginImpl;


@RestController
public class LoginController {
	
	@Autowired
	private CustomerLoginImpl customerLogin;
	
	// for user Login
		@PostMapping(value = "/login")
		public String logInCustomer(@Valid @RequestBody LoginDTO customerDTO) {
			return customerLogin.logIntoAccount(customerDTO);
		}
		
		// for user Logout
		@PatchMapping(value = "/logout")
		public String logOutCustomer(@RequestParam(required = false) String key) {
			return customerLogin.logOutFromAccount(key);
		}

}

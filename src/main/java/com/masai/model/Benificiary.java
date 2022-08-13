package com.masai.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class Benificiary {

	private String name;
	private String mobileNumber;
	
	
}

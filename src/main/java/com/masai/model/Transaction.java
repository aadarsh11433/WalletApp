package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

	@Id
	private Integer transactionId;
	private String transactionType;
	private LocalDate  transactionDate;
	private String description;
	private double amount;
	
	@OneToOne
	private Wallet wallet;
	
}

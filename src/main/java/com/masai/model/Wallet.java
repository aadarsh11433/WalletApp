package com.masai.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer walletid;
  private double balance;
 
 @OneToMany(cascade = CascadeType.ALL)
 private List<BankAccount> bankaccounts = new ArrayList<BankAccount>();

 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
// @JsonIgnore
// @JoinColumn(name = "customer_id",referencedColumnName = "cid")
 private Customer customer;
 
 
}

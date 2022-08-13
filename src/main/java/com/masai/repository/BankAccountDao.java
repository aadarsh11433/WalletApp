package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer>{
	
	public Optional<BankAccount> findByAccountNo(int accountNo);

}

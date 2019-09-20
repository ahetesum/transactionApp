package com.tran.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tran.app.model.BankAccount;

public interface BankAccountRepository extends MongoRepository<BankAccount, Integer>{

	
	@Query(value="{ userId : ?0}")
	public BankAccount getBankAccountByUserId(int userId);
}

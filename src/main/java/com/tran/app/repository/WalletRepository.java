package com.tran.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tran.app.model.Wallet;

public interface WalletRepository extends MongoRepository<Wallet, Integer> {

	@Query(value="{ userId : ?0}")
	public Wallet getWalletByUserId(int userId);
}

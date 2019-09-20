package com.tran.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tran.app.model.User;

public interface UserRepository extends MongoRepository<User, Integer>
{

}

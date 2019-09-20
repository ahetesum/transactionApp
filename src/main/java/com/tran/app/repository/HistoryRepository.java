package com.tran.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tran.app.model.History;

public interface HistoryRepository  extends MongoRepository<History, Integer>
{

}

package com.herya.jms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {
}

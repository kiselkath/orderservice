package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface to interact with MongoDB Atlas.
 */
public interface OrderRepository extends MongoRepository<Order, String> {
    // TODO: Extend default query methods if needed
}


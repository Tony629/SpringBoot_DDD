package com.javaguide.mongodb;

import com.javaguide.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Tony Zhang
 **/
@Repository
public interface IOrderRepository extends MongoRepository<Order, String>{
}

package com.snail.test.repository;

import com.snail.test.es.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemService extends MongoRepository<Item, Long> {
}

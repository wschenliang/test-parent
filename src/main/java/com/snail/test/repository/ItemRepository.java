package com.snail.test.repository;

import com.snail.test.es.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ItemRepository extends ElasticsearchCrudRepository<Item, Long> {
}

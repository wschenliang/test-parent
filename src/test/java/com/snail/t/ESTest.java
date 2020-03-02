package com.snail.t;

import com.snail.test.TestApplication;
import com.snail.test.es.Item;
import com.snail.test.repository.ItemRepository;
import com.snail.test.repository.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class ESTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    public void testCreatIndex() {
        Item item = new Item(1L,"坐宝马开奔驰，家用电器西门子", "car", "BWM", 2000.00, "http://www.woniutoutiao.com");
        //itemRepository.save(item);
        itemService.save(item);
    }



}

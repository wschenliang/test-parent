package com.snail.test.entity;

import com.snail.test.pojo.CommonPojo;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class TestEntity extends CommonPojo {
    private static final long serialVersionUID = 660013163272098988L;
    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

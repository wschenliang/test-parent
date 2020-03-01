package com.snail.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude={org.activiti.spring.boot.SecurityAutoConfiguration.class})
@MapperScan("com.snail.test.mapper")
public class TestApplication {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(TestApplication.class, args);
    }
}

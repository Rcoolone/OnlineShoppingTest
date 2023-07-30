package com.rcoolone.onlineshoppingtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.rcoolone.onlineshoppingtest.db.mappers")
//@ComponentScan("com.rcoolone")
public class OnlineShoppingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingTestApplication.class, args);
    }

}

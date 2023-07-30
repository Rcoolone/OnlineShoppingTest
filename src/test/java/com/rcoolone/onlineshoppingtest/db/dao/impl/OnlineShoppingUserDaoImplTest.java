package com.rcoolone.onlineshoppingtest.db.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingUserDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class OnlineShoppingUserDaoImplTest {

    @Resource
    OnlineShoppingUserDao dao;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void queryUserById() throws JsonProcessingException {
        OnlineShoppingUser onlineShoppingUser = dao.queryUserById(2L);
        log.info(objectMapper.writeValueAsString(onlineShoppingUser));
    }

    @Test
    void insertUser() throws JsonProcessingException {
        OnlineShoppingUser record = OnlineShoppingUser.builder()
                .userId(2L)
                .name("liSi")
                .email("liSi.hotmail.com")
                .address("cdefgab")
                .phone("234477689")
                .userType(1)
                .build();
        dao.insertUser(record);

    }
}
package com.rcoolone.onlineshoppingtest.db.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingCommodityDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class OnlineShoppingCommodityDaoImplTest {

    @Resource
    OnlineShoppingCommodityDao dao;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void insertCmomodity() throws JsonProcessingException {
        OnlineShoppingCommodity record = OnlineShoppingCommodity.builder()
                .commodityId(1L)
                .commodityName("IPHONE")
                .commodityDesc("This is Iphone 13")
                .availableStock(10)
                .creatorUserId(1L)
                .totalStock(100)
                .price(999)
                .build();

        dao.insertCommodity(record);
        OnlineShoppingCommodity onlineShoppingCommodity = dao.queryCommodityByCommodityId(1L);
        log.info(objectMapper.writeValueAsString(onlineShoppingCommodity));
    }

    @Test
    void updateCommodity() {
    }

    @Test
    void listAllCommodityByUserId() throws JsonProcessingException {
        dao.listAllCommodityByUserId(1L);
        OnlineShoppingCommodity onlineShoppingCommodity = dao.queryCommodityByCommodityId(1L);
        log.info(objectMapper.writeValueAsString(onlineShoppingCommodity));
    }

    @Test
    void listAllCommodity() {
    }

    @Test
    void queryCommocity() {
    }

    @Test
    void deleteCommodity() {
    }
}
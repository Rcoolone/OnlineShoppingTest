package com.rcoolone.onlineshoppingtest.service;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingCommodityDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityService {

    @Resource
    OnlineShoppingCommodityDao commodityDao;

    public OnlineShoppingCommodity getCommodityByCommodityId(long commodityId) {
        return commodityDao.queryCommodityByCommodityId(commodityId);
    }
}

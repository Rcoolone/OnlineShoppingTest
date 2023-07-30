package com.rcoolone.onlineshoppingtest.db.dao;

import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;


import java.util.List;


public interface OnlineShoppingCommodityDao {
    int deductStock(Long commodityId);

    int insertCommodity(OnlineShoppingCommodity record);

    int updateCommodity(OnlineShoppingCommodity record);

    List<OnlineShoppingCommodity> listAllCommodityByUserId(Long userId);

    List<OnlineShoppingCommodity> listAllCommodity();

    OnlineShoppingCommodity queryCommodityByCommodityId(Long commodityId);

    int deleteCommodity(Long commodityId);
}

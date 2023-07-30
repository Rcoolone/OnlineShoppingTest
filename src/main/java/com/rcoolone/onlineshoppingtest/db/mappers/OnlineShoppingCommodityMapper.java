package com.rcoolone.onlineshoppingtest.db.mappers;

import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;

import java.util.List;

public interface OnlineShoppingCommodityMapper {
    int deleteByPrimaryKey(Long commodityId);

    int insert(OnlineShoppingCommodity record);

    int insertSelective(OnlineShoppingCommodity record);

    OnlineShoppingCommodity selectByPrimaryKey(Long commodityId);

    int updateByPrimaryKeySelective(OnlineShoppingCommodity record);

    int updateByPrimaryKey(OnlineShoppingCommodity record);

    List<OnlineShoppingCommodity> selectByCreatorUserId(Long sellerId);

    List<OnlineShoppingCommodity> listAllCommodity();

    int deductStock(long commodityId);
}
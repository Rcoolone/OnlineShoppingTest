package com.rcoolone.onlineshoppingtest.db.dao.impl;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingCommodityDao;
import com.rcoolone.onlineshoppingtest.db.mappers.OnlineShoppingCommodityMapper;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OnlineShoppingCommodityDaoImpl implements OnlineShoppingCommodityDao {

    @Resource
    OnlineShoppingCommodityMapper mapper;


    @Override
    public int deductStock(Long commodityId) {
        return mapper.deductStock(commodityId);
    }

    @Override
    public int insertCommodity(OnlineShoppingCommodity record) {
        return mapper.insert(record);
    }

    @Override
    public int updateCommodity(OnlineShoppingCommodity record) {

        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<OnlineShoppingCommodity> listAllCommodityByUserId(Long userId) {

        return mapper.selectByCreatorUserId(userId);
    }

    @Override
    public List<OnlineShoppingCommodity> listAllCommodity() {
        return mapper.listAllCommodity();
    }

    @Override
    public OnlineShoppingCommodity queryCommodityByCommodityId(Long commodityId) {

        return mapper.selectByPrimaryKey(commodityId);
    }

    @Override
    public int deleteCommodity(Long commodityId) {

        return mapper.deleteByPrimaryKey(commodityId);
    }
}

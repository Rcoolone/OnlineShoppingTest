package com.rcoolone.onlineshoppingtest.db.dao.impl;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingOrderDao;
import com.rcoolone.onlineshoppingtest.db.mappers.OnlineShoppingOrderMapper;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingOrder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OnlineShoppingOrderDaoImpl implements OnlineShoppingOrderDao {

    @Resource
    OnlineShoppingOrderMapper mapper;
    @Override
    public int insertOrder(OnlineShoppingOrder order) {
        return mapper.insert(order);
    }

    @Override
    public OnlineShoppingOrder queryOrderById(Long orderId) {
        return mapper.selectByPrimaryKey(orderId);
    }

    @Override
    public OnlineShoppingOrder queryOrderByOrderNo(String orderNo) {
        return mapper.queryOrderByOrderNo(orderNo);
    }


    @Override
    public int updateOrder(OnlineShoppingOrder record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteOrderById(Long orderId) {
        return mapper.deleteByPrimaryKey(orderId);
    }


    @Override
    public int updateOrderById(OnlineShoppingOrder order) {
        return mapper.updateByPrimaryKeySelective(order);
    }
}

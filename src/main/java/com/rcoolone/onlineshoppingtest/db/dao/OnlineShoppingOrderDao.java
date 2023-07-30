package com.rcoolone.onlineshoppingtest.db.dao;

import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingOrder;

public interface OnlineShoppingOrderDao {
    int updateOrder(OnlineShoppingOrder record);

    int deleteOrderById(Long orderId);

    int insertOrder(OnlineShoppingOrder record);

    OnlineShoppingOrder queryOrderById(Long orderId);

    OnlineShoppingOrder queryOrderByOrderNo(String orderNo);


    int updateOrderById(OnlineShoppingOrder order);
}

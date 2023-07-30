package com.rcoolone.onlineshoppingtest.service;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingCommodityDao;
import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingOrderDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    /*
        Business Logic (single responsibility)

            check availbaleStock > 0
             1.  out of order
                  availableStock--
             2.  generate a record in order table
             3. render order status to user
     */

    @Resource
    OnlineShoppingCommodityDao commodityDao;

    @Resource
    OnlineShoppingOrderDao orderDao;

    public OnlineShoppingOrder processOrder(long userId, long commodityId) {
        OnlineShoppingCommodity onlineShoppingCommodity = commodityDao.queryCommodityByCommodityId(commodityId);
        int availableStock = onlineShoppingCommodity.getAvailableStock();
        if(availableStock > 0) {

            availableStock--;
            log.info("Process Order Sucess for commodityId: " + commodityId, "current available stock: " + availableStock);
            onlineShoppingCommodity.setAvailableStock(availableStock);
            commodityDao.updateCommodity(onlineShoppingCommodity);

            // 0: invalid order
            // 1: pending order
            // 2: finish payment
            // 99: overtime order

            OnlineShoppingOrder order = OnlineShoppingOrder.builder()
                    .commodityId(commodityId)
                    .orderNo(UUID.randomUUID().toString())
                    .createTime(new Date())
                    .orderStatus(1)
                    .userId(userId)
                    .orderAmount(10)
                    .build();

            orderDao.insertOrder(order);
            return order;
        } else {
            log.info("Process Order failed due to  out of stock, commodityId: " + commodityId);
            return null;
        }
    }

    public OnlineShoppingOrder getOrderByOrderNo(String orderNo) {
        return orderDao.queryOrderByOrderNo(orderNo);
    }

    // 0: invalid order
    // 1: pending order
    // 2: finish payment
    // 99: overtime order

    public void payOrderProcessing(String orderNo) {
        OnlineShoppingOrder order = getOrderByOrderNo(orderNo);
        // check order exist
        if(order == null) {
            log.info("The order does not exist: " + orderNo);
            return;
        }

        // check order is pending for payment
        if(order.getOrderStatus() != 1) {
            log.error("Invalid Order: " + orderNo);
            return;
        }

        order.setPayTime(new Date());
        order.setOrderStatus(2);
        orderDao.updateOrder(order);
    }

    public OnlineShoppingOrder processOrderSQLAllInOne(Long userId, Long commodityId) {
        OnlineShoppingCommodity onlineShoppingCommodity = commodityDao.queryCommodityByCommodityId(commodityId);
        int availableStock = onlineShoppingCommodity.getAvailableStock();
        if(availableStock > 0) {
            int result = commodityDao.deductStock(commodityId);
            if(result > 0) {
                log.info("Process Order success for commodityId: " + commodityId);

                OnlineShoppingOrder order = OnlineShoppingOrder.builder()
                        .commodityId(commodityId)
                        .orderNo(UUID.randomUUID().toString())
                        .createTime(new Date())
                        .orderStatus(1)
                        .userId(userId)
                        .orderAmount((int) onlineShoppingCommodity.getPrice())
                        .build();

                orderDao.insertOrder(order);

                return order;
            }
        }

        log.info("Process_order_failed_due_to_available_stock, commodityId: " + commodityId);
        return null;
    }
}

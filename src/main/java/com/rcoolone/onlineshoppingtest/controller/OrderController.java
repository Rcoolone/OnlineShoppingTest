package com.rcoolone.onlineshoppingtest.controller;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingOrderDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingOrder;
import com.rcoolone.onlineshoppingtest.service.CommodityService;
import com.rcoolone.onlineshoppingtest.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class OrderController {

    @Resource
    OnlineShoppingOrderDao orderDao;

    @Resource
    OrderService orderService;

    @Resource
    CommodityService commodityService;

//    @RequestMapping("/commodity/buy/{userId}/{commodityId}")
//    public String insertOrder(
//            @PathVariable("userId") long userId,
//            @PathVariable("commodityId") long commodityId,
//            Map<String, Object> resultMap
//    ) {
//        OnlineShoppingOrder order = OnlineShoppingOrder.builder()
//                .orderId(2L)
//                .commodityId(commodityId)
//                .orderNo(UUID.randomUUID().toString())
//                .orderAmount(2)
//                .orderStatus(1)
//                .createTime(new Date())
//                .payTime(new Date())
//                .build();
//
//        dao.insertOrder(order);
//        resultMap.put("resultInfo", order);
//        resultMap.put("orderNo", order.getOrderNo());
//
//        return "order_result";
//    }

    @RequestMapping("/commodity/buy/{userId}/{commodityId}")
    public String buyCommodity(
            @PathVariable("userId") Long userId,
            @PathVariable("commodityId") Long commodityId,
            Map<String, Object> resultMap
    ) {

        // OnlineShoppingOrder onlineShoppingOrder = orderService.processOrder(userId, commodityId);

        OnlineShoppingOrder onlineShoppingOrder = orderService.processOrderSQLAllInOne(userId, commodityId);


        if(onlineShoppingOrder == null) {
            resultMap.put("resultInfo", "The commodity is out of stock");
        } else {
            resultMap.put("resultInfo", "Order created successful, OrderNo:" + onlineShoppingOrder.getOrderNo());
            resultMap.put("orderNo", onlineShoppingOrder.getOrderNo());
        }

        return "order_result";
    }

    @GetMapping("/commodity/queryOrder/{orderNo}")
    public String queryOrderByOrderNo(
            @PathVariable("orderNo")  String orderNo,
            Map<String, Object> resultMap
    ) {
        OnlineShoppingOrder order = orderService.getOrderByOrderNo(orderNo);
        OnlineShoppingCommodity commodity = commodityService.getCommodityByCommodityId(order.getCommodityId());
        if(order == null) {
            return "error";
        } else {
            resultMap.put("commodity", commodity);
            resultMap.put("order", order);
            return "order_check";
        }

    }

    // 改 order status
    @GetMapping("/commodity/payOrder/{orderNo}")
    public String payOrder(
            @PathVariable("orderNo") String orderNo,
            Map<String, Object> resultMap
            ) {
        orderService.payOrderProcessing(orderNo);
        return "redirect:/commodity/queryOrder/{orderNo}";
    }

}

package com.rcoolone.onlineshoppingtest.controller;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingCommodityDao;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingCommodity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {
    @Resource
    OnlineShoppingCommodityDao dao;

    @RequestMapping("/")
    public String defaultItems(Map<String, Object> resultMap) {
        List<OnlineShoppingCommodity> listOfonlineShoppingCommodities = dao.listAllCommodityByUserId(1L);

        resultMap.put("itemList", listOfonlineShoppingCommodities);
        listOfonlineShoppingCommodities.get(0).getCommodityName();

        return "list_items";

    }
    @RequestMapping("/addItem")
    public String addItem() {
        return "add_commodity";
    }

    @PostMapping("/addItemAction")
    public String addItemAction(
            @RequestParam("commodityId") long commodityId,
            @RequestParam("commodityName") String commodityName,
            @RequestParam("commodityDesc") String commodityDesc,
            @RequestParam("price") int price,
            @RequestParam("availableStock") int availableStock,
            @RequestParam("creatorUserId") long creatorUserId,
            Map<String, Object> resultMap
    ) {
        OnlineShoppingCommodity commodity = OnlineShoppingCommodity.builder()
                                .commodityId(commodityId)
                                .commodityName(commodityName)
                                .commodityDesc(commodityDesc)
                                .price(price)
                                .availableStock(availableStock)
                                .totalStock(availableStock)
                                .creatorUserId(creatorUserId)
                                .build();
        dao.insertCommodity(commodity);
        resultMap.put("Item",commodity);
        return "add_commodity_success";
    }

    @RequestMapping("/listItems/{sellerId}")
    public String listItems(
            @PathVariable("sellerId") String sellerId,
            Map<String, Object> resultMap) {
        List<OnlineShoppingCommodity> listOfonlineShoppingCommodities = dao.listAllCommodityByUserId(Long.parseLong(sellerId));

        resultMap.put("itemList", listOfonlineShoppingCommodities);

        return "list_items";
    }

    @GetMapping("/item/{commodityId}")
    public String itemDetail(
            @PathVariable("commodityId") String commodityId,
            Map<String, Object> resultMap)
     {
        OnlineShoppingCommodity onlineShoppingCommodity = dao.queryCommodityByCommodityId(Long.parseLong(commodityId));
        resultMap.put("commodity", onlineShoppingCommodity);

        return "item_detail";
    }

}

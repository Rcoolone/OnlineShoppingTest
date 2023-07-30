package com.rcoolone.onlineshoppingtest.db.po;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingOrderDao;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class OnlineShoppingOrder implements OnlineShoppingOrderDao {
    private Long orderId;

    private String orderNo;

    private Integer orderStatus;

    private Long commodityId;

    private Integer orderAmount;

    private Date createTime;

    private Date payTime;

    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int updateOrder(OnlineShoppingOrder record) {
        return 0;
    }

    @Override
    public int deleteOrderById(Long orderId) {
        return 0;
    }

    @Override
    public int insertOrder(OnlineShoppingOrder record) {
        return 0;
    }

    @Override
    public OnlineShoppingOrder queryOrderById(Long orderId) {
        return null;
    }

    @Override
    public OnlineShoppingOrder queryOrderByOrderNo(String orderNo) {
        return null;
    }


    @Override
    public int updateOrderById(OnlineShoppingOrder order) {
        return 0;
    }
}
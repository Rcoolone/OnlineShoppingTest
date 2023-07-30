package com.rcoolone.onlineshoppingtest.db.dao;


import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingUser;

public interface OnlineShoppingUserDao {
        OnlineShoppingUser queryUserById(Long userId);

        int insertUser(OnlineShoppingUser user);


}
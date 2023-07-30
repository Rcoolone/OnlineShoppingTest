package com.rcoolone.onlineshoppingtest.db.dao.impl;

import com.rcoolone.onlineshoppingtest.db.dao.OnlineShoppingUserDao;
import com.rcoolone.onlineshoppingtest.db.mappers.OnlineShoppingUserMapper;
import com.rcoolone.onlineshoppingtest.db.po.OnlineShoppingUser;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OnlineShoppingUserDaoImpl implements OnlineShoppingUserDao {

    @Resource
    OnlineShoppingUserMapper mapper;

    @Override
    public OnlineShoppingUser queryUserById(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int insertUser(OnlineShoppingUser user) {
        return mapper.insert(user);
    }
}

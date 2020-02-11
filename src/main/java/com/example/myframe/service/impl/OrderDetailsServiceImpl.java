package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.OrderDetailsDao;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.OrderDetailsBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.OrderDetailsService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单详情业务逻辑层
 */
@Service
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsDao,OrderDetailsBean> implements OrderDetailsService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Override
    public List<OrderDetailsBean> getAll() {
        return orderDetailsDao.getAll();
    }

    @Override
    public IPage<OrderDetailsBean> getPage() {
        return orderDetailsDao.getPage();
    }

    @Override
    public OrderDetailsBean get(String name) {
        return orderDetailsDao.get(name);
    }
}

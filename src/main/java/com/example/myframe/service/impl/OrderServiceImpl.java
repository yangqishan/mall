package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.OrderDao;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.OrderBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.OrderService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单业务逻辑层
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao,OrderBean> implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<OrderBean> getAll() {
        return orderDao.getAll();
    }

    @Override
    public IPage<OrderBean> getPage() {
        return orderDao.getPage();
    }

    @Override
    public OrderBean get(String name) {
        return orderDao.get(name);
    }
}

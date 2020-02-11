package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.CartDao;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.CartBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.CartService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车业务逻辑层
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartDao,CartBean> implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public List<CartBean> getAll() {
        return cartDao.getAll();
    }

    @Override
    public IPage<CartBean> getPage() {
        return null;
    }

    @Override
    public CartBean get(String name) {
        return cartDao.get(name);
    }
}

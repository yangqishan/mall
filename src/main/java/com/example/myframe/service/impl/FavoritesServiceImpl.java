package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏夹业务逻辑层
 */
@Service
public class FavoritesServiceImpl extends ServiceImpl<UserDao,UserBean> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserBean> getAll() {
        return userDao.getAll();
    }

    @Override
    public IPage<UserBean> getPage() {
        return null;
    }

    @Override
    public UserBean get(String name) {
        return userDao.get(name);
    }
}

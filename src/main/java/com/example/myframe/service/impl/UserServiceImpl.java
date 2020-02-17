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
 * 会员业务逻辑层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,UserBean> implements UserService {
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

    @Override
    public UserBean getByXh(String xh) {
        return userDao.getByXh(xh);
    }

    @Override
    public void add(UserBean userBean) {
        userDao.add(userBean);
    }

    @Override
    public void edit(UserBean userBean) {
        userDao.edit(userBean);
    }

    @Override
    public void editPwd(UserBean userBean) {
        userDao.editPwd(userBean);
    }
}

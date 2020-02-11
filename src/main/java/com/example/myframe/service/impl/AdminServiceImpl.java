package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.AdminDao;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.AdminService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员业务逻辑层
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao,AdminBean> implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<AdminBean> getAll() {
        return adminDao.getAll();
    }

    @Override
    public IPage<AdminBean> getPage() {
        return adminDao.getPage();
    }

    @Override
    public AdminBean get(String name) {
        return adminDao.get(name);
    }
}

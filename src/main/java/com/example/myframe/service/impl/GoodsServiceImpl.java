package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.GoodsDao;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.GoodsService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品业务逻辑层
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao,GoodsBean> implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<GoodsBean> getAll() {
        return goodsDao.getAll();
    }

    @Override
    public List<GoodsBean> getByType(String type) {
        return goodsDao.getByType(type);
    }

    @Override
    public List<GoodsBean> getByFlag(String flag) {
        return goodsDao.getByFlag(flag);
    }
    @Override
    public List<GoodsBean> getSale(String type) {
        return goodsDao.getSale(type);
    }

    @Override
    public IPage<GoodsBean> getPage() {
        return goodsDao.getPage();
    }

    @Override
    public List<GoodsBean> getFavorites() {
        return goodsDao.getFavorites();
    }

    @Override
    public List<GoodsBean> get(String name) {
        return goodsDao.get(name);
    }
}

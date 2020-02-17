package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.FavoritesDao;
import com.example.myframe.entity.FavoritesBean;
import com.example.myframe.service.FavoritesService;
import com.example.myframe.vo.CartFavoritesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesDao,FavoritesBean> implements FavoritesService {

    @Autowired
    private FavoritesDao favoritesDao;
    @Override
    public List<FavoritesBean> getAll() {
        return favoritesDao.getAll();
    }

    @Override
    public IPage<FavoritesBean> getPage() {
        return null;
    }

    @Override
    public FavoritesBean get(FavoritesBean favorites) {
        return favoritesDao.get(favorites);
    }

    @Override
    public List<CartFavoritesVo> getByXh(String xh) {
        return favoritesDao.getByXh(xh);
    }

    @Override
    public void add(FavoritesBean favoritesBean) {
        favoritesDao.add(favoritesBean);
    }
}

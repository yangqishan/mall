package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.FavoritesBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.CartFavoritesVo;

import java.util.List;


public interface FavoritesService extends IService<FavoritesBean>{
    List<FavoritesBean> getAll();

    IPage<FavoritesBean> getPage();

    FavoritesBean get(FavoritesBean favorites);

    List<CartFavoritesVo> getByXh(String xh);
    void add(FavoritesBean favoritesBean);
}

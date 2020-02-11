package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.FavoritesBean;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface FavoritesService extends IService<FavoritesBean>{
    List<FavoritesBean> getAll();

    IPage<FavoritesBean> getPage();

    FavoritesBean get(String name);
}

package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface GoodsService extends IService<GoodsBean>{
    List<GoodsBean> getAll();

    List<GoodsBean> getByType(String type);
    List<GoodsBean> getSale(String type);

    List<GoodsBean> getByFlag(String flag);

    IPage<GoodsBean> getPage();


    GoodsBean get(String name);
}

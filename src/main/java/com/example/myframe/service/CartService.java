package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.CartBean;


import java.util.List;


public interface CartService extends IService<CartBean>{
    List<CartBean> getAll();

    IPage<CartBean> getPage();

    CartBean get(String name);
}

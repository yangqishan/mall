package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.OrderBean;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface OrderService extends IService<OrderBean>{
    List<OrderBean> getAll();

    IPage<OrderBean> getPage();

    OrderBean get(String name);
}

package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.OrderDetailsBean;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface OrderDetailsService extends IService<OrderDetailsBean>{
    List<OrderDetailsBean> getAll();

    IPage<OrderDetailsBean> getPage();

    OrderDetailsBean get(String name);
}

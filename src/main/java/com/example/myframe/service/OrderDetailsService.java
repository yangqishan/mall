package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.OrderDetailsBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.OrdersVo;

import java.util.List;


public interface OrderDetailsService extends IService<OrderDetailsBean>{
    List<OrdersVo> getAll(String userXh);

    IPage<OrderDetailsBean> getPage();

    OrderDetailsBean get(String name);

    //创建订单
    void create(OrderDetailsBean orderDetailsBean);

    OrderDetailsBean getOne();
}

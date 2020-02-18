package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.OrderDetailsBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.OrdersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDetailsDao extends BaseMapper<OrderDetailsBean> {

    List<OrdersVo> getAll(String userXh);
    /**
     * 分页查询
     * @return
     */
    IPage<OrderDetailsBean> getPage();

    OrderDetailsBean get(String name);
    //创建订单
    void create(OrderDetailsBean orderDetailsBean);

    OrderDetailsBean getOne();

}



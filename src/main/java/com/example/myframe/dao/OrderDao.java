package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.OrderBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.CartFavoritesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDao extends BaseMapper<OrderBean> {

    List<OrderBean> getAll();

    /**
     * 分页查询
     * @return
     */
    IPage<OrderBean> getPage();

    List<CartFavoritesVo> getBydetailsId(int detailsId);

    void add(List<OrderBean> list);
}



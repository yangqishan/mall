package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.CartBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.CartFavoritesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CartDao extends BaseMapper<CartBean> {

    List<CartBean> getAll();
    /**
     * 分页查询
     * @return
     */
    IPage<CartBean> getPage();

    CartBean get(CartBean cart);

    List<CartFavoritesVo> getByXh(String xh);

    void edit(CartBean cart);

    void add(CartBean cartBean);

    void del(CartBean cartBean);
}



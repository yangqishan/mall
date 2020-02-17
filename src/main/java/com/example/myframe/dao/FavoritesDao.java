package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.FavoritesBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.CartFavoritesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FavoritesDao extends BaseMapper<FavoritesBean> {

    List<FavoritesBean> getAll();

    /**
     * 分页查询
     * @return
     */
    IPage<FavoritesBean> getPage();

    FavoritesBean get(FavoritesBean favorites);

    List<CartFavoritesVo> getByXh(String xh);

    void add(FavoritesBean favoritesBean);

}



package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsDao extends BaseMapper<GoodsBean> {

    List<GoodsBean> getAll();

    List<GoodsBean> getByType(String type);

    List<GoodsBean> getSale(String type);

    List<GoodsBean> getByFlag(String flag);

    List<GoodsBean> getFavorites();

    List<GoodsBean> getLike(String name);

    List<GoodsBean> gets(int [] goodsId);
    /**
     * 分页查询
     * @return
     */
    IPage<GoodsBean> getPage();

    List<GoodsBean> get(String name);

}



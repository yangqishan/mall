package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.CartBean;
import com.example.myframe.vo.CartFavoritesVo;


import java.util.List;


public interface CartService extends IService<CartBean>{
    List<CartBean> getAll();

    IPage<CartBean> getPage();

    CartBean get(CartBean cart);

    List<CartFavoritesVo> getByXh(String xh);

    void edit(CartBean cart);

    void add(CartBean cartBean);

    void del(CartBean cartBean);
}

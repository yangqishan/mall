package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.CartBean;
import com.example.myframe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value="cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value="/add")
    public RestResponse add(@RequestParam(value="userXh") String userXh,
                            @RequestParam(value="goodsId") int goodsId,
                            @RequestParam(value="price") Float price,
                            @RequestParam(value="number") int number,
                            @RequestParam(value="flag") String flag){
        //创建一个购物车对象
        CartBean cartBean=new CartBean();
        cartBean.setFlag(flag);
        cartBean.setGoodsId(goodsId);
        cartBean.setNumber(number);
        cartBean.setUserXh(userXh);
        cartBean.setPrice(price);
        CartBean cartBean1=cartService.get(cartBean);
        //判断是都添加
        if(cartBean1!=null){
            cartBean.setNumber(cartBean1.getNumber()+number);
            //重新修改数量
            cartService.edit(cartBean);
        }else{
            //添加到数据库
            cartService.add(cartBean);
        }
        return new RestResponse(ResultEnum.SUCCESS);

    }
}
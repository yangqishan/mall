package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.FavoritesBean;
import com.example.myframe.service.FavoritesService;
import com.example.myframe.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 添加到收藏夹
     * @param goodId
     * @param userXh
     * @return
     */
    @RequestMapping(value="/add")
    public RestResponse add(@RequestParam(value="goodId") int goodId,
                            @RequestParam(value="userXh") String userXh){
        String flag="";
        //创建一个收藏夹对象
        FavoritesBean favoritesBean=new FavoritesBean();
        favoritesBean.setGoodsId(goodId);
        favoritesBean.setUserXh(userXh);
        //先判断是否已经添加到数据库
        FavoritesBean favorites=favoritesService.get(favoritesBean);
        if(favorites==null){
            //添加到数据库
            favoritesService.add(favoritesBean);
            flag="添加成功";
        }else{

        }
        return new RestResponse(ResultEnum.SUCCESS,flag);

    }
}

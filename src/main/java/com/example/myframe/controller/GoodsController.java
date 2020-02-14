package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 */
@RestController
@RequestMapping(value="/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取所有的商品
     * @return
     */
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<GoodsBean> list=goodsService.getAll();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 根据不同类型查询商品
     * @param goodsType
     * @return
     */
    @RequestMapping(value="getByType")
    public RestResponse getByType(@RequestParam(value="goodsType") String goodsType){
        //定义一个map集合
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsBean> products=goodsService.getByType(goodsType);
        map.put("products",products);
        List<GoodsBean> sale=goodsService.getSale(goodsType);
        map.put("sale",sale);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 根据不同的标识查询
     * @return
     */
    @RequestMapping(value="getByFalg")
    public RestResponse getByFlag(@RequestParam(value="flag") String flag,
                                  @RequestParam(value="goodsType",defaultValue = "") String goodsType){
        //定义一个map集合
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsBean> products=goodsService.getByFlag(flag);
        map.put("products",products);
        List<GoodsBean> sale=goodsService.getSale(goodsType);
        map.put("sale",sale);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 模糊搜索
     * @param searchValue
     * @return
     */
    @RequestMapping(value="/find")
    public RestResponse find(@RequestParam(value="searchValue") String searchValue){
        //定义一个map集合
        Map<String,Object> map=new HashMap<>();
        //获取模糊查询的结果
        List<GoodsBean> list=goodsService.get(searchValue);
        map.put("products",list);
        List<GoodsBean> list1=goodsService.getFavorites();
        map.put("favorites",list1);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }
}

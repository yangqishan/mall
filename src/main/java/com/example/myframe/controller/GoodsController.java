package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<GoodsBean> list=goodsService.getAll();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    @RequestMapping(value="getByType")
    public RestResponse getByType(@RequestParam(value="goodsType") String goodsType){
        List<GoodsBean> list=goodsService.getByType(goodsType);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }
}

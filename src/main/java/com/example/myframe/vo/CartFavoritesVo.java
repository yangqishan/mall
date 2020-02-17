package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class CartFavoritesVo extends DateBean{
    private int id;
    private String userXh;//账号
    private int goodsId;//商品id
    private String name;//名字
    private String details;//详细信息
    private Float price;//价格
    private int number;//数量
    private Float money;//金额
    private String img;//照片
    private String flag;//标识
}

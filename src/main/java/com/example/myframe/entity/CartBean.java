package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("cart")
@NoArgsConstructor
@AllArgsConstructor
public class CartBean extends DateBean{
    @TableId
    private int id;
    private String userXh;//会员账号
    private int goodsId;//商品id
    private Float price;//商品价格
    private int number;//购买数量
    private String flag;//标识

}

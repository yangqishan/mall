package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("order")
@NoArgsConstructor
@AllArgsConstructor
public class OrderBean extends DateBean{
    @TableId
    private int id;
    private int goodsId;//商品id
    private String flag;//标识
    private Float money;//价格
    private int number;//数量
    private int orderdetailsId;//订单详情id
}

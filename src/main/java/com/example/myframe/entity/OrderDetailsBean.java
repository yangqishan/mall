package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("orderdetails")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsBean extends DateBean{
    @TableId
    private int id;
    private int userId;//会员id
    private int number;//商品总数量
    private Float money;//总金额
    private String status;//状态
    private int orderNumber;//订单编号
    private String pay;//支付方式
    private String address;//收货地址
}

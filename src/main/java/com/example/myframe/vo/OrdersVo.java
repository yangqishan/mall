package com.example.myframe.vo;

import com.example.myframe.entity.AddressBean;
import com.example.myframe.entity.DateBean;
import com.example.myframe.entity.OrderBean;
import lombok.Data;

import java.util.List;

@Data
public class OrdersVo extends DateBean{

    private int id;
    private String userXh;//会员账号
    private int number;//商品总数量
    private Float money;//总金额
    private String status;//状态
    private String orderNumber;//订单编号
    private String pay;//支付方式
    private int addressId;//地址id
    private AddressBean address;//收货地址
    private List<CartFavoritesVo> list;//订单详情信息
}

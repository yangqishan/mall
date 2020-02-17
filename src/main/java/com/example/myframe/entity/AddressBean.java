package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressBean extends DateBean {
    @TableId
    private int id;
    private String userXh;//账号
    private String name;//收货人姓名
    private String tel;//电话
    private String userAddress;//收货地址
    private String email;//邮箱
    private String postcode;//邮编

}

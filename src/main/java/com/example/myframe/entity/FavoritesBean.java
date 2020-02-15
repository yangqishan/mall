package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("favorites")
@NoArgsConstructor
@AllArgsConstructor
public class FavoritesBean {
    @TableId
    private int id;
    private String userXh;//用户账号
    private int goodsId;//商品id
    private String flag;//标识
}

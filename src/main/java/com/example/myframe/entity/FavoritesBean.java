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
    private int userId;//用户id
    private int goodsId;//商品id
    private String flag;//标识
}

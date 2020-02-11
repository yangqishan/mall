package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("goods")
@NoArgsConstructor
@AllArgsConstructor
public class GoodsBean extends DateBean{
    @TableId
    private int id;
    private String name;//名字
    private String details;//详细信息
    private Float price;//价格
    private int number;//数量
    private int browse;//浏览量
    private int purchase;//购买量
    private int favorites;//收藏次数
    private Float discountPrice;//折扣价格
    private String img;//图片
    private String type;//  类型（包装还是散称）
    private String flag;//标识
    private String activity;//活动
}

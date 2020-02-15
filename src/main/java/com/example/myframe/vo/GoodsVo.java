package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVo extends DateBean{
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
    private List<BrandVo> activity;//活动
}

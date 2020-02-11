package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("admin")
@AllArgsConstructor
@NoArgsConstructor
public class AdminBean extends DateBean{
    @TableId
    private int id;
    private String name;//姓名
    private String password;//密码

}

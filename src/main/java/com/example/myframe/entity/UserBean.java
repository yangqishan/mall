package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class UserBean extends DateBean{
    @TableId
    private int id;
    private String xh;//账号
    private String name;//姓名
    private String password;//密码
    private int age;//年龄
    private String sex;//性别
    private String tel;//电话
    private String address;//地址
    private String level;//等级
    private Float integral;//积分
    private String img;//头像

}

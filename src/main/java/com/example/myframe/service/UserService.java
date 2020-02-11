package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface UserService extends IService<UserBean>{
    List<UserBean> getAll();

    IPage<UserBean> getPage();

    UserBean get(String name);
}

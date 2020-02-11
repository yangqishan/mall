package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.UserBean;

import java.util.List;


public interface AdminService extends IService<AdminBean>{
    List<AdminBean> getAll();

    IPage<AdminBean> getPage();

    AdminBean get(String name);
}

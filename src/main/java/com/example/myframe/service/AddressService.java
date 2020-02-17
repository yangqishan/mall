package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.AddressBean;
import java.util.List;


public interface AddressService extends IService<AddressBean>{
    List<AddressBean> getAll();

    IPage<AddressBean> getPage();

    List<AddressBean> get(String userXh);

    void add(AddressBean addressBean);

    void edit(AddressBean addressBean);
}

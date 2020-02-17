package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.AddressDao;
import com.example.myframe.entity.AddressBean;
import com.example.myframe.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao,AddressBean> implements AddressService {

    @Autowired
    private AddressDao addressDao;
    @Override
    public List<AddressBean> getAll() {
        return addressDao.getAll();
    }

    @Override
    public IPage<AddressBean> getPage() {
        return addressDao.getPage();
    }

    @Override
    public List<AddressBean> get(String userXh) {
        return addressDao.get(userXh);
    }

    @Override
    public void add(AddressBean addressBean) {
        addressDao.add(addressBean);
    }

    @Override
    public void edit(AddressBean addressBean) {
        addressDao.edit(addressBean);
    }

}

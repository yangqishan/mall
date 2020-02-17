package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.AddressBean;
import com.example.myframe.entity.AdminBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AddressDao extends BaseMapper<AddressBean> {
    List<AddressBean> getAll();
    /**
     * 分页查询
     * @return
     */
    IPage<AddressBean> getPage();

    List<AddressBean> get(String userXh);

    void add(AddressBean addressBean);
    void edit(AddressBean addressBean);
}

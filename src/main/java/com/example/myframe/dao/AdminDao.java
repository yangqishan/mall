package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.AdminBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminDao extends BaseMapper<AdminBean> {
    List<AdminBean> getAll();
    /**
     * 分页查询
     * @return
     */
    IPage<AdminBean> getPage();

    AdminBean get(String name);
}

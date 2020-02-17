package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserDao extends BaseMapper<UserBean> {

    List<UserBean> getAll();
    /**
     * 分页查询
     * @return
     */
    IPage<UserBean> getPage();

    UserBean get(String name);

    UserBean getByXh(String xh);

    void add(UserBean userBean);

    void edit(UserBean userBean);

    void editPwd(UserBean userBean);
}



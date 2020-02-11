package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.aop.Permission;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.redis.RedisUtils;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TestController {

    @RequestMapping(value="/find")
    public String get(HttpServletRequest request){
        request.setAttribute("current",1);
        request.setAttribute("size",5);
        return "index";
    }


    
    @RequestMapping(value = "/findByname")
    @Permission
    @ResponseBody
    public RestResponse findByname(){
        return new RestResponse(ResultEnum.SUCCESS,"有权限");
    }

}

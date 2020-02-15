package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员控制层
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取会员登录信息
     * @param name
     * @return
     */
    @RequestMapping(value="/get")
    public RestResponse get(@RequestParam(value="name") String name,
                            HttpServletRequest request){
        //获取session的数值
        name=request.getSession().getAttribute("name").toString();
        UserBean userBean=userService.get(name);
        return new RestResponse(ResultEnum.SUCCESS,userBean);
    }

    /**
     * 会员号登录
     * @param xh
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value="/login")
    public RestResponse login(@RequestParam(value="xh") String xh,
                              @RequestParam(value="password") String password,
                              HttpServletRequest request){
        //查询会员信息
        UserBean userBean=userService.getByXh(xh);
        //设置标识
        String flag="";
        if(userBean==null){
            flag="账号不存在";
        }else if(!userBean.getPassword().equals(password)){
            flag="密码错误";
        }else{
            request.getSession().setAttribute("name",userBean.getName());
        }
        return new RestResponse(ResultEnum.SUCCESS,flag);

    }

    /**
     * 会员退出
     * @param request
     * @return
     */
    @RequestMapping(value="/exit")
    public RestResponse exit(HttpServletRequest request){
        //清除账户信息
        request.getSession().removeAttribute("name");
        return new RestResponse(ResultEnum.SUCCESS);
    }

}

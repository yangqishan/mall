package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.AddressBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.AddressService;
import com.example.myframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 会员控制层
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    /**
     * 获取会员登录信息
     * @return
     */
    @RequestMapping(value="/get")
    public RestResponse get(HttpServletRequest request){
        //获取session的数值
        String xh=request.getSession().getAttribute("xh").toString();
        UserBean userBean=userService.getByXh(xh);
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
        String msg="";
        if(userBean==null){
            msg="账号不存在";
        }else if(!userBean.getPassword().equals(password)){
            msg="密码错误";
        }else{
            //将账号存入session
            request.getSession().setAttribute("xh",userBean.getXh());
        }
        return new RestResponse(ResultEnum.SUCCESS,msg);

    }

    /**
     * 会员退出
     * @param request
     * @return
     */
    @RequestMapping(value="/exit")
    public RestResponse exit(HttpServletRequest request){
        //清除账户信息
        request.getSession().removeAttribute("xh");
        return new RestResponse(ResultEnum.SUCCESS);
    }

    /**
     * 会员注册
     * @param xh
     * @param name
     * @param tel
     * @param pwd
     * @param code
     * @return
     */
    @RequestMapping(value="/register")
    public RestResponse register(@RequestParam(value="xh") String xh,
                                  @RequestParam(value="name") String name,
                                  @RequestParam(value="tel") String tel,
                                  @RequestParam(value="pwd") String pwd,
                                  @RequestParam(value="code") String code,
                                 HttpServletRequest request){
        //获取验证码
        String code1=request.getSession().getAttribute("code").toString();
        //先判断该账户是否存在
        UserBean userBean=userService.getByXh(xh);
        String msg="";
        if(!code1.equals(code)){
            msg="验证码错误";
        }else if(userBean==null){
            UserBean userBean1=new UserBean();
            userBean1.setXh(xh);
            userBean1.setName(name);
            userBean1.setTel(tel);
            userBean1.setPassword(pwd);
            userBean1.setIntegral((float)0);
            userBean1.setLevel("普通会员");
            userService.add(userBean1);
            msg="注册成功";
        }else{
            msg="账号已经存在";
        }
        //创建一个会员对象
        return new RestResponse(ResultEnum.SUCCESS,msg);
    }


    /**
     * 修改会员的值
     * @param xh
     * @param name
     * @param age
     * @param sex
     * @param tel
     * @return
     */
    @RequestMapping(value="edit")
    public RestResponse edit(@RequestParam(value="xh") String xh,
                             @RequestParam(value="name") String name,
                             @RequestParam(value="age") int age,
                             @RequestParam(value="sex") String sex,
                             @RequestParam(value="tel") String tel){
        //创建一个会员对象
        UserBean userBean=new UserBean();
        userBean.setXh(xh);
        userBean.setName(name);
        userBean.setSex(sex);
        userBean.setAge(age);
        userBean.setTel(tel);
        //修改
        userService.edit(userBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }

    /**
     * 修改密码
     * @param pwd
     * @param newpwd
     * @param newpwds
     * @return
     */
    @RequestMapping(value="/updatePassword")
    public RestResponse updatePassword(@RequestParam(value="pwd") String pwd,
                                       @RequestParam(value="newpwd") String newpwd,
                                       @RequestParam(value="newpwds") String newpwds,
                                       @RequestParam(value="xh") String xh,
                                       HttpServletRequest request){
        String msg="";
        UserBean userBean=userService.getByXh(xh);
        //先判断原密码是否一致
        if(pwd.equals(userBean.getPassword())){
            //重新设置密码
            userBean.setPassword(newpwd);
            userService.editPwd(userBean);
            msg="修改成功";
            //并清楚session
            request.getSession().removeAttribute("xh");
        }else{
            msg="原密码错误";
        }

        return new RestResponse(ResultEnum.SUCCESS,msg);
    }

    /**
     * 查询所有的收货地址
     * @param userXh
     * @return
     */
    @RequestMapping(value="getAddress")
    public RestResponse getAddress(@RequestParam(value="userXh") String userXh,
                                   HttpServletRequest request){
        userXh=request.getSession().getAttribute("xh").toString();
        List<AddressBean> list=addressService.get(userXh);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 添加新地址
     * @param userXh
     * @param name
     * @param userAddress
     * @param email
     * @param tel
     * @param postcode
     * @return
     */
    @RequestMapping(value="addAddress")
    public RestResponse addAddress(@RequestParam(value="userXh") String userXh,
                                   @RequestParam(value="name") String name,
                                   @RequestParam(value="userAddress") String userAddress,
                                   @RequestParam(value="email") String email,
                                   @RequestParam(value="tel") String tel,
                                   @RequestParam(value="postcode") String postcode){
        //创建地址对象
        AddressBean addressBean=new AddressBean();
        addressBean.setUserXh(userXh);
        addressBean.setUserAddress(userAddress);
        addressBean.setEmail(email);
        addressBean.setName(name);
        addressBean.setPostcode(postcode);
        addressBean.setTel(tel);
        //存到数据库中
        addressService.add(addressBean);
        return new RestResponse(ResultEnum.SUCCESS,addressBean);
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @RequestMapping(value="delAddress")
    public RestResponse delAddress(@RequestParam(value="id") int id){
        addressService.removeById(id);
        return new RestResponse(ResultEnum.SUCCESS);
    }

    /**
     * 修改收货地址
     * @param id
     * @param name
     * @param userAddress
     * @param email
     * @param tel
     * @param postcode
     * @return
     */
    @RequestMapping(value="editAddress")
    public RestResponse edit(@RequestParam(value="id") int id,
                             @RequestParam(value="name") String name,
                             @RequestParam(value="userAddress") String userAddress,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="tel") String tel,
                             @RequestParam(value="postcode") String postcode){
        AddressBean addressBean=new AddressBean();
        addressBean.setId(id);
        addressBean.setName(name);
        addressBean.setUserAddress(userAddress);
        addressBean.setTel(tel);
        addressBean.setPostcode(postcode);
        addressBean.setEmail(email);
        //去数据库修改
        addressService.edit(addressBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }
}

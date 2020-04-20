package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.*;
import com.example.myframe.service.*;
import com.example.myframe.vo.CartFavoritesVo;
import com.example.myframe.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value="/orders")
public class OrdersController {

    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    /**
     * 创建订单
     * @param goodsId//商品id数组
     * @param flag//标识数组
     * @param number //数量数组
     * @param price//价格数组
     * @param userId//会员账号
     * @param numbers//总数
     * @param money//总金额
     * @param payss//支付方式
     * @param addressId
     * @return
     */
    @RequestMapping(value="/create")
    public RestResponse createOrders(@RequestParam(value="goodsId") int[] goodsId,
                                     @RequestParam(value="flag") String[] flag,
                                     @RequestParam(value="number") int[] number,
                                     @RequestParam(value="price") Float[] price,
                                     @RequestParam(value="userId") String userId,
                                     @RequestParam(value="numbers") int numbers,
                                     @RequestParam(value="money") Float money,
                                     @RequestParam(value="payss") String payss,
                                     @RequestParam(value="addressId") int addressId,
                                     @RequestParam(value="type") String type){
        //创建订单对象
        OrderDetailsBean orderDetailsBean=new OrderDetailsBean();
        orderDetailsBean.setUserXh(userId);
        orderDetailsBean.setMoney(money);
        orderDetailsBean.setNumber(numbers);
        orderDetailsBean.setPay(payss);
        orderDetailsBean.setStatus("出库");
        orderDetailsBean.setAddressId(addressId);
        orderDetailsBean.setOrderNumber(getRandomNickname(20));
        orderDetailsBean.setFlag(type);
        //添加到数据库
        orderDetailsService.create(orderDetailsBean);
        //存订单详情信息
        OrderDetailsBean orderDetailsBean1=orderDetailsService.getOne();
        //订单id
        int detailsId=orderDetailsBean1.getId();
        //创建订单详情list集合
        List<OrderBean> list=new ArrayList<>();
        for(int i=0;i<goodsId.length;i++){
            //创建订单详情对象
           OrderBean orderBean=new OrderBean();
           CartBean cartBean=new CartBean();
           orderBean.setGoodsId(goodsId[i]);
           //购物车信息存储
           cartBean.setGoodsId(goodsId[i]);
           cartBean.setUserXh(userId);
           //删除信息
           cartService.del(cartBean);
           orderBean.setFlag(flag[i]);
           orderBean.setNumber(number[i]);
           orderBean.setMoney(number[i]*price[i]);
           orderBean.setOrderdetailsId(detailsId);
           //加入list集合
           list.add(orderBean);
        }

        //list集合存到数据库
        orderService.add(list);
        return new RestResponse(ResultEnum.SUCCESS);
    }
    //随机生10位字母加数字的组合
      public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
        val += String.valueOf(random.nextInt(10));
        }
        return val;
        }

    /**
     * 查询所有订单
     * @param usrXh
     * @return
     */
    @RequestMapping(value="/getAll")
        public RestResponse getAll(@RequestParam(value="userXh") String usrXh){
        Map<String,Object> map=new HashMap<>();
        //会员信息
        UserBean userBean=userService.getByXh(usrXh);
        map.put("user",userBean);
        //查询所有订单根据账号
        List<OrdersVo> details=orderDetailsService.getAll(usrXh);
        for(int i=0;i<details.size();i++){
            OrdersVo ordersVo=details.get(i);
            //获取地址信息
            AddressBean addressBean=addressService.getById(ordersVo.getAddressId());
            details.get(i).setAddress(addressBean);
            //获取订单详情
            List<CartFavoritesVo> list=orderService.getBydetailsId(ordersVo.getId());
            details.get(i).setList(list);
        }
        map.put("orders",details);
        return new RestResponse(ResultEnum.SUCCESS,map);
        }

    /*public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }*/
}

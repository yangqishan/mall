package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.AddressBean;
import com.example.myframe.entity.GoodsBean;
import com.example.myframe.service.AddressService;
import com.example.myframe.service.GoodsService;
import com.example.myframe.util.JsonUtil;
import com.example.myframe.vo.BrandVo;
import com.example.myframe.vo.GoodsVo;
import com.example.myframe.vo.SizeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 */
@RestController
@RequestMapping(value="/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AddressService addressService;
    /**
     * 获取所有的商品
     * @return
     */
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<GoodsBean> list=goodsService.getByFlag("正常");
        return new RestResponse(ResultEnum.SUCCESS,list);
    }


    /**
     * 根据不同类型查询商品
     * @param goodsType
     * @return
     */
    @RequestMapping(value="getByType")
    public RestResponse getByType(@RequestParam(value="goodsType") String goodsType){
        //定义一个map集合
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsBean> products=goodsService.getByType(goodsType);
        map.put("products",products);
        List<GoodsBean> sale=goodsService.getSale(goodsType);
        map.put("sale",sale);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 根据不同的标识查询
     * @return
     */
    @RequestMapping(value="getByFalg")
    public RestResponse getByFlag(@RequestParam(value="flag") String flag,
                                  @RequestParam(value="goodsType",defaultValue = "") String goodsType){
        //定义一个map集合
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsBean> products=goodsService.getByFlag(flag);
        map.put("products",products);
        List<GoodsBean> sale=goodsService.getSale(goodsType);
        map.put("sale",sale);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 模糊搜索
     * @param searchValue
     * @return
     */
    @RequestMapping(value="/find")
    public RestResponse find(@RequestParam(value="searchValue") String searchValue){
        //定义一个map集合
        Map<String,Object> map=new HashMap<>();
        //获取模糊查询的结果
        List<GoodsBean> list=goodsService.get(searchValue);
        map.put("products",list);
        List<GoodsBean> list1=goodsService.getFavorites();
        map.put("favorites",list1);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }
    //根据id查询商品的详细信息
    @RequestMapping(value="/getById")
    public RestResponse getById(@RequestParam(value="goods_id") int good_id){
        //获取详细信息
        GoodsBean goodsBean=goodsService.getById(good_id);
        //对象转换
        GoodsVo goodsVo=new GoodsVo();
        goodsVo.setId(goodsBean.getId());
        goodsVo.setName(goodsBean.getName());
        goodsVo.setDetails(goodsBean.getDetails());
        goodsVo.setBrowse(goodsBean.getBrowse());
        goodsVo.setDiscountPrice(goodsBean.getDiscountPrice());
        goodsVo.setFavorites(goodsBean.getFavorites());
        goodsVo.setFlag(goodsBean.getFlag());
        goodsVo.setImg(goodsBean.getImg());
        goodsVo.setNumber(goodsBean.getNumber());
        goodsVo.setPrice(goodsBean.getPrice());
        goodsVo.setPurchase(goodsBean.getPurchase());
        goodsVo.setType(goodsBean.getType());

        if(goodsBean.getActivity()==null||goodsBean.getFlag()=="活动"){

        }else{
            //品种详情数据格式转换
            //分割每个品种
            String [] brand=goodsBean.getActivity().split(";");
            List<BrandVo> brandVos=new ArrayList<>();
            for(int i=0;i<brand.length;i++){
                //创建品种对象
                BrandVo brandVo=new BrandVo();
                List<SizeVo> sizes=new ArrayList<>();
                //分割每个品种下的大小包装
                String [] size=brand[i].split(",");
                brandVo.setVarieties(size[0]);
                for(int j=1;j<size.length;j++){
                    String[] data=size[j].split(":");
                    //创建大小对象
                    SizeVo size1=new SizeVo();
                    size1.setName(data[0]);
                    size1.setPrice(Float.parseFloat(data[1]));
                    sizes.add(size1);
                }
                brandVo.setList(sizes);
                brandVos.add(brandVo);
            }
            goodsVo.setActivity(brandVos);
        }

        return new RestResponse(ResultEnum.SUCCESS,goodsVo);
    }

    /**
     *搜索查询可能喜欢
     * @param name
     * @return
     */
    @RequestMapping(value="getLike")
    public RestResponse getLike(@RequestParam(value="name") String name){
        List<GoodsBean> like=goodsService.getLike(name);
        return new RestResponse(ResultEnum.SUCCESS,like);
    }

    /**
     * 生成订单信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value="/orders")
    public RestResponse get(@RequestParam(value="goodsId") int[] goodsId,
                            @RequestParam(value="userXh") String userXh,
                            @RequestParam(value="flag") String[] flag,
                            @RequestParam(value="number") int[] number,
                            @RequestParam(value="price") Float[] price){
        //创建map对象
        Map<String,Object> map=new HashMap<>();
        List<AddressBean> address=addressService.get(userXh);
        map.put("address",address);
        //将所有商品查询出来
        List<GoodsBean> list=goodsService.gets(goodsId);
        List<GoodsVo> products=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            GoodsVo goodsVo=new GoodsVo();
            goodsVo.setId(list.get(i).getId());
            goodsVo.setName(list.get(i).getName());
            goodsVo.setDetails(list.get(i).getDetails());
            goodsVo.setImg(list.get(i).getImg());
            if(flag[i].equals("特价--")||flag[i].equals("积分")||flag[i].equals("活动")){
                goodsVo.setPrice(list.get(i).getPrice());
                goodsVo.setDiscountPrice(price[i]);
            }else{
                goodsVo.setPrice(price[i]);
                goodsVo.setDiscountPrice(price[i]);
            }
            goodsVo.setNumber(number[i]);
            goodsVo.setFlag(flag[i]);
            products.add(goodsVo);
        }
        map.put("products",products);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }
}

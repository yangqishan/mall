
/*//通过id获取商品信息
function getDetails(obj) {
    console.log($(obj).attr("title"))
}*/
//添加商品到收藏夹
function favorites(id,userId) {
    if(userId==null){
        layer.msg("没有登录",{icon:5,time:1500},function (index) {
            window.location.href="Login.html"
        })
    }else{
        //添加到数据库
        $.ajax({
            url:"favorites/add",
            type:"post",
            dataType:"json",
            data:{
                goodId:id,
                userXh:userId
            },
            success:function (data) {
                if(data.data.length==0){
                    layer.msg("已经添加过",{icon:5,time:1500});
                }else{
                    layer.msg(data.data,{icon:1,time:1500});
                }

            }
        })

    }



}
//添加商品到购物车
function cart(id,flag,userId,price,number) {
    if(userId==null){
        layer.msg("没有登录",{icon:5,time:1500},function (index) {
            window.location.href="Login.html"
        })
    }else{
        //添加到数据库
        $.ajax({
            url:"cart/add",
            type:"post",
            dataType:"json",
            data:{
                goodsId:id,
                userXh:userId,
                flag:flag,
                price:price,
                number:number
            },
            success:function (data) {
                    layer.msg("成功加入",{icon:6,time:1500});
            }
        })

    }

}

//跳转到订单页面
function  orders(id,userId,flag,number,price) {
    if(userId==null){
        layer.msg("没有登录",{icon:5,time:1500},function (index) {
            window.location.href="Login.html"
        })
    }else{
        //跳转订单页面
        window.open("Orders.html?id="+id+"&userId="+userId+"&flag="+flag+"&number="+number+"&price="+price)
    }
}
//创建订单
function createOrders(numbers,money,payss,addressId,type){
    var id=getQueryString("id")//商品id(或者数组)
    var userId=getQueryString("userId")//会员账号(或者字符串数组)
    var flag=getQueryString("flag")//标识(或者字符串数组)
    var number=getQueryString("number")//数量(或者字符串数组)
    var price=getQueryString("price")//价格(或者字符串数组)
    //异步请求创建订单
    $.ajax({
        url:"orders/create",
        type:"post",
        dataType:"json",
        data:{
            goodsId:id,//商品id数组
            flag:flag,//标识数组
            number:number,//数量数组
            price:price,//价格数组
            userId:userId,//会员账号
            numbers:numbers,//总数
            money:money,//总金额
            payss:payss,//支付方式
            addressId:addressId,//收地地址id
            type:type//订单类型
        },
        success:function (data) {
            layer.msg("订单生产成功",{icon:1,time:1500},function (index) {
                window.location.href="user_order.html?userXh="+userId
            })
        }
    })

}



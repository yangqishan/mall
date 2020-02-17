
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



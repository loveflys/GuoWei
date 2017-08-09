<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/> 
<title>${companyName} - ${currentUser.name}</title>
<!-- iCheck -->
<link rel="stylesheet" href="<%=path%>/res/plugins/wechat/aui.css">
<!-- Morris chart -->
<link rel="stylesheet" href="<%=path%>/res/plugins/wechat/search.css">
<!-- jvectormap -->
<link rel="stylesheet" href="<%=path%>/res/plugins/wechat/iconfont.css">
<style type="text/css">
        .red-point {
            width: 20px;
		    height: 20px;
		    position: absolute;
		    right: 10px;
		    top: 10px;
		    background-color: red;
		    border-radius: 50%;
		    color: white;
		    font-size: 12px;
		    display: flex;
		    align-items: center;
		    justify-content: center;
        }
        .aui-list-view.aui-grid-view .aui-list-view-cell .aui-img-object {
            padding-bottom: 5px;
        }

        .aui-list-view.aui-grid-view .aui-list-view-cell {
            padding: 10px 0 5px 10px;
        }

        .aui-list-view.aui-grid-view .aui-list-view-cell a {
            padding: 10px 0 5px 0 !important;
        }

        .aui-list-view.aui-grid-view .aui-list-view-cell .aui-img-body {
            font-size: 12px;
            padding: inherit;
        }
        footer .bgm {
            z-index: 10;
            position: absolute;
		    top: 0;
		    right: 0;
		    bottom: 0;
		    left: 0;
		    background-color: #000;
		    opacity: .4;
		    -webkit-transition: opacity .35s ease;
		    transition: opacity .35s ease;
        }
        footer .cart-body {
            z-index: 11;
            bottom: 370px;
	        position: fixed;
		    left: 0;
		    width: 100%;
		    background-color: #fff;
		    -webkit-transition: all .35s ease;
		    transition: all .35s ease;
		    -webkit-transform: translate3d(0,100%,0);
		    transform: translate3d(0,100%,0);
        }
        footer .cart-body .title{
            padding: 0 10px;
		    border-bottom: 1px solid #ddd;
		    background-color: #eceff1;
		    color: #666;
		    line-height: 30px;
        }
        footer .cart-body .title .buycart{
            padding-left: 5px;
            border-left: 3px solid #3190e8;
        }
        footer .cart-body .title a {
            float: right;
		    padding-left: 10px;
		    background-size: 10px;
		    color: #666;
		    text-decoration: none;
		    font-size: 12px;    
        }
        footer .cart-body .title i {
            width: 18px;
            height: 18px;
            fill: #ddd;  
        }
        footer .cart-body .container{
            overflow: auto;
		    -webkit-overflow-scrolling: touch;
		    height: 280px;
        }
        footer .cart-body .container ul{
            list-style: none;
            padding: 0;
            margin: 0;
        }
        footer .cart-body .container ul li{
            border-bottom: 1px solid #eee;
            display: -webkit-box;
		    display: -ms-flexbox;
		    display: flex;
		    -webkit-box-align: center;
		    -ms-flex-align: center;
		    align-items: center;  
        }
        footer .cart-body .container ul li .subtitle{
            -webkit-box-flex: 5.5;
		    -ms-flex: 5.5;
		    flex: 5.5;
		    line-height: normal;   
        }
        footer .cart-body .container ul li .subtitle em{
            display: inline-block;
		    font-style: normal;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		    vertical-align: middle;
		    max-width: 220px;
        }
        footer .cart-body .container ul li .subtitle p{
            white-space: nowrap;
		    line-height: .333333rem;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    color: #999;
		    font-size: .266667rem;
        }
        footer .cart-body .container ul li .price {
            -webkit-box-flex: 2.5;
		    -ms-flex: 2.5;
		    flex: 2.5;
		    color: #f60;
		    text-align: right;
		    white-space: nowrap;
		    font-weight: 700;    
        }
        footer .cart-body .container ul li .price .value {
             
        }
        footer .cart-body .container ul li .price .value:before {
            content: "\A5";
		    font-size: .266667rem;
		    color: currentColor;
        }
        footer .cart-body .container ul li .manager {
            -webkit-box-flex: 3;
		    -ms-flex: 3;
		    flex: 3;
		    display: block;
		    width: 0;
		    text-align: right;
        }
        footer .cart-body .container ul li .manager .manager-body {
            display: inline-block;
		    font-size: .346667rem;
		    white-space: nowrap;
        }
        footer .cart-body .container ul li .manager .manager-body .minus {
            display: inline-block;
		    padding: .093333rem;
		    vertical-align: middle;
		    text-decoration: none;
        }
        footer .cart-body .container ul li .manager .manager-body .minus i, footer .cart-body li .manager .manager-body .plus i {
            width: 40px;
            height: 50px;
            vertical-align: middle;
            fill: #3190e8;
            font-size: 25px;
		    display: flex;
		    align-items: center;
		    justify-content: center;
        }
        footer .cart-body .container ul li .manager .manager-body .number {
            display: inline-block;
            vertical-align: middle;
            text-align: center;
		    color: #666;
		    font-size: .373333rem;
		    min-width: .4rem;
		    max-width: 2em;
		    overflow: hidden;    
        }
        footer .cart-body .container ul li .manager .manager-body .plus {
            display: inline-block;
		    padding: .093333rem;
		    vertical-align: middle;
		    text-decoration: none;
        }
        .footer {
            z-index: 11;
            position: fixed;
		    right: 0;
		    bottom: 0;
		    left: 0;
		    display: -webkit-box;
		    display: -ms-flexbox;
		    display: flex;
		    -webkit-box-align: center;
		    -ms-flex-align: center;
		    align-items: center;
		    padding-left: 100px;
		    background-color: #3d3d3f;
		    height: 60px;
		    opacity: 0.95;
        }
        .footer .cart {
            position: absolute;
		    left: 20px;
		    bottom: 7px;
		    width: 60px;
		    height: 60px;
		    box-sizing: border-box;
		    border-radius: 100%;
		    border: 7px solid #444;
		    box-shadow: 0 -.08rem .053333rem 0 rgba(0,0,0,.1);
		    will-change: transform;
        }
        .footer .cart.goods {
            background-color: #3190e8;
        }
        .footer .cart:before {
		    position: absolute;
		    top: 0;
		    right: 0;
		    bottom: 0;
		    left: 0;
		    background: url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OCA1OCIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPjxkZWZzPjxmaWx0ZXIgaWQ9ImEiIHdpZHRoPSIyMDAlIiBoZWlnaHQ9IjIwMCUiIHg9Ii01MCUiIHk9Ii01MCUiIGZpbHRlclVuaXRzPSJvYmplY3RCb3VuZGluZ0JveCI+PGZlT2Zmc2V0IGluPSJTb3VyY2VBbHBoYSIgcmVzdWx0PSJzaGFkb3dPZmZzZXRPdXRlcjEiLz48ZmVHYXVzc2lhbkJsdXIgc3RkRGV2aWF0aW9uPSIxLjUiIGluPSJzaGFkb3dPZmZzZXRPdXRlcjEiIHJlc3VsdD0ic2hhZG93Qmx1ck91dGVyMSIvPjxmZUNvbG9yTWF0cml4IHZhbHVlcz0iMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMC4wOCAwIiBpbj0ic2hhZG93Qmx1ck91dGVyMSIgcmVzdWx0PSJzaGFkb3dNYXRyaXhPdXRlcjEiLz48ZmVNZXJnZT48ZmVNZXJnZU5vZGUgaW49InNoYWRvd01hdHJpeE91dGVyMSIvPjxmZU1lcmdlTm9kZSBpbj0iU291cmNlR3JhcGhpYyIvPjwvZmVNZXJnZT48L2ZpbHRlcj48cGF0aCBpZD0iYiIgZD0iTTcuNjE0IDQuMDUxYy0xLjA2Ni4wODYtMS40NTItLjM5OC0xLjc1Mi0xLjU4NEM1LjU2MiAxLjI4LjMzIDUuODguMzMgNS44OGwzLjcxIDE5LjQ3NmMwIC4xNDgtMS41NiA3LjUxNS0xLjU2IDcuNTE1LS40ODkgMi4xOS4yOTIgNC4yNyAzLjU2IDQuMzIgMCAwIDM2LjkxNy4wMTcgMzYuOTIuMDQ3IDEuOTc5LS4wMTIgMi45ODEtLjk5NSAzLjAxMy0zLjAzOS4wMy0yLjA0My0xLjA0NS0yLjk3OC0yLjk4Ny0yLjk5M0w4LjgzIDMxLjE5MnMuODYtMy44NjUgMS4wNzctMy44NjVjMCAwLTUuNzg4LjEyMiAzMi4wNjUtMS45NTYuNjA2LS4wMzMgMi4wMTgtLjc2NCAyLjI5OC0xLjg0OCAxLjExMy00LjMxNyA0LjAwOC0xMy4yNiA0LjQ1OC0xNS42NC45MzItNC45MjUgMi4wNjEtOC41NTgtNC4yOC03LjQwNSAwIDAtMzUuNzY4IDMuNDg3LTM2LjgzMyAzLjU3M3oiLz48L2RlZnM+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIiBmaWx0ZXI9InVybCgjYSkiIHRyYW5zZm9ybT0idHJhbnNsYXRlKDMgMikiPjxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDUuMDM4IDcuODA4KSI+PG1hc2sgaWQ9ImMiIGZpbGw9IiNmZmYiPjx1c2UgeGxpbms6aHJlZj0iI2IiLz48L21hc2s+PHVzZSBmaWxsPSIjRkZGIiB4bGluazpocmVmPSIjYiIvPjxwYXRoIGZpbGw9IiMyMDczQzEiIGQ9Ik01My45NjIgNy43NzRsLTUuNzAxIDE5LjMwNS00MC43OCAxLjU3NHoiIG9wYWNpdHk9Ii4xIiBtYXNrPSJ1cmwoI2MpIi8+PC9nPjxwYXRoIHN0cm9rZT0iI0ZGRiIgc3Ryb2tlLXdpZHRoPSI2IiBkPSJNOS4zNzQgMTguNzIyUzcuODY4IDExLjI4MyA3LjMyMyA4LjcxQzYuNzc4IDYuMTM2IDUuODYgNS4zMyAzLjk3OCA0LjUyIDIuMDk2IDMuNzEzLjM2NyAyLjI4Ni4zNjcgMi4yODYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPjxjaXJjbGUgY3g9IjQ2IiBjeT0iNTEiIHI9IjQiIGZpbGw9IiNGRkYiLz48Y2lyY2xlIGN4PSIxMiIgY3k9IjUxIiByPSI0IiBmaWxsPSIjRkZGIi8+PC9nPjwvc3ZnPg==) 50% no-repeat;
		    background-size: 30px;
		    content: "";
		}
		.footer .cart:after {
            position: absolute;
		    right: 1px;
		    top: -6px;
		    background-color: #ff461d;
		    color: #fff;
		    border-radius: 8px;
		    padding: 0px 3px;
		    content: attr(attr-quantity);
		    font-size: 12px;
        }
        .footer .buy-info {
            flex: 1;
		    display: block;
		    width: 0;
        }
        .footer .buy-info .buy-info-price {
            color: #fff;
		    font-size: 17px;
		    line-height: normal;
		    font-weight: 400;
		    font-family: 'Helvetica Neue',Tahoma,Arial,PingFangSC-Regular,'Hiragino Sans GB','Microsoft Yahei',sans-serif;
        }
        .footer .submitBtn {
	        height: 100%;
		    width: 120px;
		    background-color: #4cd964;
		    color: #fff;
		    text-align: center;
		    text-decoration: none;
		    font-size: 16px;
		    font-weight: 700;
		    line-height: 60px;    
        }
        .footer .submitBtn.disabled {
            background-color: #535356;
        }
</style>
</head>
<body>
    <div class="hor-search">
        <div class="search-leftbar">
            <ul class="mb50" id="mb50">
                <li id="firstpro" onclick="change(this)" class="search-leftbar-cur"><a>第一货架</a></li>
                <li id="secondpro" onclick="change(this)"><a>第二货架</a></li>
                <li id="thirdpro" onclick="change(this)"><a>第三货架</a></li>
                <li id="forthpro" onclick="change(this)"><a>第四货架</a></li>
            </ul>
        </div>
        <div class="search-rightbar" id="proContainer">
        </div>
        <footer>
            <div class="bgm" onclick="toggleCart()" style="display:none;"></div>
	        <div class="cart-body" style="display:none;">
	           <div class="title">
                    <span class="buycart">购物车</span>
                    <a href="javascript:clearCart();">
                        <i class="fa fa-trash-o"></i>
                        <span>清空</span>
                    </a>
                </div>
	        
	           <div class="container">
                    <ul id="cartProContainer">
                        
                    </ul>
                </div>
	        </div>
	        <div class="footer">
			    <span id="cartnum" onclick="toggleCart()" class="cart"> <!-- attr-quantity="1" -->
			    </span>
			    <div class="buy-info" onclick="toggleCart()">
			      
			      <p class="buy-info-price">￥<span id="totalAmount">0</span></p>
			    </div>
			    <a class="submitBtn disabled" onclick="submit()">去结算</a>
			</div>
		</footer>
        
        
    </div>
    <script type="text/html" id="cart_tpl">
        [[ if (data) { ]]
            [[ for(var i = 0, length = data.length; i< length; i++) { var item = data[i]; ]]
                    <li id="cartpro_{{item.id}}">
                        <div class="subtitle">
                            <em>{{item.proname}}</em>
                            <p></p>
                        </div>
                        <div class="price">
                            <span class="value">{{item.proprice}}</span>
                        </div>
                        <div class="manager">
                            <div class="manager-body">
                                <a class="minus" onclick="minusCartPro('{{item.id}}')">
                                   <i class="fa fa-minus-circle"></i>
                                </a>
                                <span class="number">{{item.number}}</span>
                                <a class="plus" onclick="addtoCart('{{item.id}}', '{{item.number}}', '{{item.stock}}')">
                                   <i class="fa fa-plus-circle"></i>
                                </a>
                            </div>
                        </div>
                    </li>
            [[ } ]]
        [[  } ]]
    </script>
    <script type="text/html" id="pro_tpl">
        [[ if(data){ ]] 
            <div class="aui-content list-detail-show" id="first_pro_body">
            <div class="the-onelm-name">${companyName}</div>
            <div>
                <h4 class="aui-txt-font14 aui-text-333"><div class="leimu-left-fg"></div>第一层货架</h4>
                [[if(data[1]&&data[1].length>0){ ]]
                    <ul class="aui-list-view aui-grid-view">
                        [[for(var j=0;j< data[1].length;j++){ var item = data[1][j]; ]]
                            <li id="pro_{{item.id}}" class="aui-list-view-cell aui-img aui-col-xs-6" onclick="addtoCart('{{item.id}}', '{{item.number}}', '{{item.stock}}')"> 
                                <p id="point_{{item.id}}" class="red-point" style="display:none;"></p>
                                <img class="aui-img-object" src="{{ item.proimage }}"/>
                                <a class="aui-img-body">{{ item.proname }}</a>
                                <a style="color: red;padding: 0 !important;margin: 0;">￥{{ item.proprice }}</a>
                            </li>
                        [[ } ]]
                    </ul>
                [[ } ]] 
            </div>
            </div>

            <div class="aui-content list-detail-show" id="second_pro_body" style="display:none;">
            <div class="the-onelm-name">${companyName}</div>
            <div>
                <h4 class="aui-txt-font14 aui-text-333"><div class="leimu-left-fg"></div>第二层货架</h4>
                [[if(data[2]&&data[2].length>0){ ]]
                    <ul class="aui-list-view aui-grid-view">
                        [[for(var j=0;j< data[2].length;j++){ var item = data[2][j]; ]]
                            <li id="pro_{{item.id}}" class="aui-list-view-cell aui-img aui-col-xs-6" onclick="addtoCart('{{item.id}}', '{{item.number}}', '{{item.stock}}')"> 
                                <p id="point_{{item.id}}" class="red-point" style="display:none;"></p>
                                <img class="aui-img-object" src="{{ item.proimage }}"/>
                                <a class="aui-img-body">{{ item.proname }}</a>
                                <a style="color: red;padding: 0 !important;margin: 0;">￥{{ item.proprice }}</a>
                            </li>
                        [[ } ]]
                    </ul>
                [[ } ]] 
            </div>
            </div>


            <div class="aui-content list-detail-show" id="third_pro_body" style="display:none;">
            <div class="the-onelm-name">${companyName}</div>
            <div>
                <h4 class="aui-txt-font14 aui-text-333"><div class="leimu-left-fg"></div>第三层货架</h4>
                [[if(data[3]&&data[3].length>0){ ]]
                    <ul class="aui-list-view aui-grid-view">
                        [[for(var j=0;j< data[3].length;j++){ var item = data[3][j]; ]]
                            <li id="pro_{{item.id}}" class="aui-list-view-cell aui-img aui-col-xs-6" onclick="addtoCart('{{item.id}}', '{{item.number}}', '{{item.stock}}')"> 
                                <p id="point_{{item.id}}" class="red-point" style="display:none;"></p>
                                <img class="aui-img-object" src="{{ item.proimage }}"/>
                                <a class="aui-img-body">{{ item.proname }}</a>
                                <a style="color: red;padding: 0 !important;margin: 0;">￥{{ item.proprice }}</a>
                            </li>
                        [[ } ]]
                    </ul>
                [[ } ]] 
            </div>
            </div>


            <div class="aui-content list-detail-show" id="forth_pro_body" style="display:none;">
            <div class="the-onelm-name">${companyName}</div>
            <div>
                <h4 class="aui-txt-font14 aui-text-333"><div class="leimu-left-fg"></div>第四层货架</h4>
                [[if(data[4]&&data[4].length>0){ ]]
                    <ul class="aui-list-view aui-grid-view">
                        [[for(var j=0;j< data[4].length;j++){ var item = data[4][j]; ]]
                            <li id="pro_{{item.id}}" class="aui-list-view-cell aui-img aui-col-xs-6" onclick="addtoCart('{{item.id}}', '{{item.number}}', '{{item.stock}}')"> 
                                <p id="point_{{item.id}}" class="red-point" style="display:none;"></p>
                                <img class="aui-img-object" src="{{ item.proimage }}"/>
                                <a class="aui-img-body">{{ item.proname }}</a>
                                <a style="color: red;padding: 0 !important;margin: 0;">￥{{ item.proprice }}</a>
                            </li>
                        [[ } ]]
                    </ul>
                [[ } ]] 
            </div>
            </div>
        [[ } ]]
    </script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
    <script src="http://www.css88.com/doc/underscore/underscore-min.js"></script>
    <script>
        window.param = {
        	all: [],
        	cart: [],
        	amount: 0,
        	showCart: false,
        }
        $(function() {
        	_.templateSettings = {
                evaluate    : /\[\[(.+?)\]\]/g,
                interpolate : /\{\{(.+?)\}\}/g
            };       
        	FastClick.attach(document.body);
        	getData();
        })
        function getData() {
        	$.ajax({
                cache: false,
                type: "POST",
                url: "<%=path%>/company/getProData",
                data: {
                	id: ${id}
                },
                async: false,
                error: function(request) {
                    toastr.error("Server Connection Error...");
                },
                success: function(res) {
                	window.param.all = res.data;
                	var list = _.groupBy(res.data, 'storageracks');
                    bindData(list);
                }
            });
        }
        function bindData(data) {
            if (data == null) {
                return;
            }
            var tpl = $("#pro_tpl").html();
            var _tpl = _.template(tpl);
            $("#proContainer").html("");
            $("#proContainer").append(_tpl({
                "data": data
            }));
        }
        function change(obj) {
        	var index = $(obj).attr('id');
        	$(obj).addClass('search-leftbar-cur');
        	$(obj).siblings().removeClass('search-leftbar-cur');
        	switch(index) {
        	   case 'firstpro':
        		   $("#first_pro_body").show();
        		   $("#first_pro_body").siblings().hide();
        		   break;
        	   case 'secondpro':
                   $("#second_pro_body").show();
                   $("#second_pro_body").siblings().hide();
                   break;
        	   case 'thirdpro':
                   $("#third_pro_body").show();
                   $("#third_pro_body").siblings().hide();
                   break;
        	   case 'forthpro':
                   $("#forth_pro_body").show();
                   $("#forth_pro_body").siblings().hide();
                   break;       
        	}
        }
        //清空购物车
        function clearCart() {
        	window.param.cart = [];
        	window.param.amount = 0;
        	$("#cartnum").removeAttr('attr-quantity');
        	$("#cartnum").removeClass('goods');
        	$("#totalAmount").text(0);
        	$("#cartProContainer").html('');
        	if (!$(".submitBtn").hasClass('disabled')) {
                $(".submitBtn").addClass('disabled');
                $(".submitBtn").removeAttr("onclick");
            }
        	toggleCart();
        }
        function addtoCart(id) {
        	var item = null;
            let number = 0;
        	let has = false;
        	let amount = 0;
        	
        	window.param.cart.map((e)=> {
        		if (e.id == id) {
        			item = e;
        			has = true;
        			number = e.number = e.number+1;
        		}
        		amount += e.number * e.proprice;
        	});
        	if (item && item.number > item.stock) {
        		swal({    title: "提示",    text: "库存不足！",    timer: 2000,    showConfirmButton: false  });
        		item.number = item.stock;
        		number = item.stock;
        		$("#point_"+id).show();
                $("#point_"+id).html(number);
                return false;
        	}
        	if (!has) {
        		window.param.all.map((e)=> {
                    if (e.id == id) {
                        item = e;
                    }
                });
        		if (item.stock <= 0) {
                    swal({    title: "提示",    text: "库存不足！",    timer: 2000,    showConfirmButton: false  });
                    return;
                }
        		item.number = 1;
        		number = 1;
        		window.param.cart.push(item);
        		amount += item.proprice;        		
        	}
        	$("#point_"+id).show();
        	$("#point_"+id).html(number);
        	$("#totalAmount").text(amount.toFixed(2));
        	var tempNum = 0;
        	if (window.param.cart && window.param.cart.length > 0) {
        	    var tempArr = [];
        	    tempArr = _.pluck(window.param.cart, 'number');
        	    tempNum = _.reduce(tempArr, function(memo, num){ return memo + num; }, 0);
        	}
        	$("#cartnum").attr('attr-quantity', tempNum);
        	var tpl = $("#cart_tpl").html();
            var _tpl = _.template(tpl);
            $("#cartProContainer").html(_tpl({
                "data": window.param.cart
            }));
            if (!$("#cartnum").hasClass('goods')) {
            	$("#cartnum").addClass(' goods')
            }
            if ($(".submitBtn").hasClass('disabled')) {
                $(".submitBtn").removeClass('disabled');
                $(".submitBtn").attr('onclick','submit()');
            }
        }
        function minusCartPro(id) {
            let amount = 0;
            let temp = [];
            for(var i=0,length=window.param.cart.length; i< length; i++) {
            	var e = window.param.cart[i];
            	if (e.id == id) {
                    e.number = e.number-1;
                    if (e.number == 0) {
                    	$("#cartpro_"+id).remove();
                    	$("#point_"+id).hide();
                    } else {
                    	$("#point_"+id).show();
                        $("#point_"+id).html(e.number);
                    }
                }
                if (e.number > 0) {
                    temp.push(e);
                    amount += e.number * e.proprice;
                }
            }
            window.param.cart = temp;
            if (window.param.cart.length <= 0) {
            	clearCart();
            	return;
            }
            $("#totalAmount").text(amount.toFixed(2));
            var tempNum = 0;
            if (window.param.cart && window.param.cart.length > 0) {
                var tempArr = [];
                tempArr = _.pluck(window.param.cart, 'number');
                tempNum = _.reduce(tempArr, function(memo, num){ return memo + num; }, 0);
            }
            $("#cartnum").attr('attr-quantity', tempNum);
            var tpl = $("#cart_tpl").html();
            var _tpl = _.template(tpl);
            $("#cartProContainer").html(_tpl({
                "data": window.param.cart
            }));
        }
        function toggleCart() {
        	if (!window.param.showCart && (!window.param.cart || window.param.cart.length <= 0)) {
        		return;
        	}
        	window.param.showCart = !window.param.showCart;
        	if (window.param.showCart) {
        		$('.bgm').show();
        		$('.cart-body').show();
        	} else {
        		$('.bgm').hide();
                $('.cart-body').hide();
        	}
        }
        function submit () {
        	$.ajax({
                cache: false,
                type: "POST",
                url: "<%=path%>/order/submit",
                data: {
                	companyId: '${id}',
                    companyName: '${companyName}',
                    details: JSON.stringify(window.param.cart),
                    uid: '${currentUser.id}',
                    openid: '${currentUser.wechatOpenid}',
                    uname: '${currentUser.name}'
                },
                async: false,
                error: function(request) {
                    toastr.error("Server Connection Error..."+JSON.stringify(request));
                },
                success: function(res) {
                    if (res.status) {
                    	//调用微信支付
                    	//swal({    title: "提示",    text: "订单提交成功，待支付",    timer: 2000,    showConfirmButton: false  });
                    	window.location.href= res.msg;
                    	
                    } else {
                    	 swal({    title: "提示",    text: res.msg,    timer: 2000,    showConfirmButton: false  });
                    }
                }
            });
        }
    </script>
</body>
</html>
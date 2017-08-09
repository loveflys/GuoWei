<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="include/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="x5-orientation" content="portrait">
    <link rel="stylesheet" href="/wxpay/css/weui.min.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <title>微信公众号支付测试</title>
</head>
<body>
<script src="<%= path %>/res/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
    $(function () {
    	console.log('${timeStamp}');
    	$.ajax({
            cache: false,
            type: "POST",
            url: "<%=path%>/wechat/getConfig",
            data: {
            	url: window.location.href
            },
            async: false,
            error: function(request) {
                toastr.error("Server Connection Error...");
            },
            success: function(res) {
            	console.log('配置==>' + JSON.stringify(res));
            	wx.config({  
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。  
                    appId: res.appId,     //公众号名称，由商户传入     
                    timestamp: res.timeStamp,         //时间戳，自1970年以来的秒数     
                    nonceStr: res.nonceStr, //随机串     
                    signature: res.sign, // 必填，签名，见附录1  
                    jsApiList: [  
                            "chooseWXPay"  
                    ] // 所有要调用的 API 都要加到这个列表中  
                }); 
            }
        }); 
    	 
    	 
    	 wx.ready(function() { // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。  
             wx.chooseWXPay({  
            	 appId: "${appId}",     //公众号名称，由商户传入     
            	 timeStamp: "${timeStamp}",         //时间戳，自1970年以来的秒数     
                 nonceStr: "${nonceStr}", //随机串     
                 package: "${prepayId}",     
                 signType: "MD5",         //微信签名方式：     
                 paySign: "${paySign}", //微信签名 
                 success: function(res) {  
                     // 支付成功后的回调函数  
                     if (res.errMsg == "chooseWXPay:ok") {  
                         //支付成功  
                         alert('支付成功');  
                     } else {  
                         alert(res.errMsg);  
                     }  
                 },  
                 cancel: function(res) {  
                     //支付取消  
                     alert('支付取消');  
                 }  
             });  
         });  
    })
    
</script>
</body>
</html>
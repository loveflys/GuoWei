<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>微信 | 合作申请</title>
<link rel="shortcut icon" type="image/x-icon"
    href="<%=path%>/res/home/assets/images/logo.png" />

<link href="<%=path%>/res/home/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/res/home/assets/css/bootstrap-theme.min.css" rel="stylesheet">

<link href="<%=path%>/res/home/assets/css/owl.carousel.css" rel="stylesheet">
<link href="<%=path%>/res/home/assets/css/owl.theme.default.min.css" rel="stylesheet">

<link href="<%=path%>/res/home/assets/css/magnific-popup.css" rel="stylesheet">

<link href="<%=path%>/res/home/assets/css/style.css" rel="stylesheet">
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

<style>
.cay-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
}
.cay-group .cay-cell {
    display: flex;
    align-items: center;
    height: 55px;
    border-bottom: 1px solid #e0e0e0;
}
.cay-cell.large {
    height: 88px;
}
.cay-group .cay-cell .cell-title {
    width: 105px;
    text-align: center;
}
.cay-group .cay-cell .cell-value {
    flex: 1;
}
.cay-group .cay-cell .cell-value input, .cay-group .cay-cell .cell-value textarea {
    width: 100%;
    outline:none;
    resize:none;
    border: 0;
}
.cay-btn {
    width: 100%;
    height: 50px;
    border-top: 1px solid #e0e0e0;
    text-align: center;
    line-height: 50px;
    position: fixed;
    bottom: 0;
    font-size: 18px;
    background-color: #74bd74;
    color: #fff;
}
</style>
</head>
<body>
    <div class="cay-group">
        <div class="cay-cell large">
            <div class="cell-title">意见/建议</div>
            <div class="cell-value">
                <textarea id="content" placeholder="请输入意见/建议"></textarea>
            </div>
        </div>
        <div class="cay-cell">
            <div class="cell-title">联系人电话</div>
            <div class="cell-value">
                <input id="contactPhone" type="text" value="" placeholder="请输入联系人电话" />
            </div>
        </div>
    </div>
    <div class="cay-btn" onclick="submit()">提交</div>
    <script src="<%=path%>/res/home/assets/js/jquery-3.1.1.js"></script>
    <script src="<%=path%>/res/home/assets/js/bootstrap.min.js"></script>
    <script src="<%=path%>/res/home/assets/js/owl.carousel.min.js"></script>
    <script src="https://use.fontawesome.com/55b73bf748.js"></script>
    <script src="<%=path%>/res/home/assets/js/jquery.magnific-popup.js"></script>
    <script src="<%=path%>/res/home/assets/js/script.js"></script>
    <script>
    function submit () {
        var content = $("#content").val();
        var contactPhone = $("#contactPhone").val();
        if (!content || (content + '').length <= 0) {
            toastr.error('请输入意见/建议');
            return;
        }
        if (!contactPhone || (contactPhone + '').length <= 0) {
            toastr.error('请输入联系人电话');
            return;
        }
        $.ajax({
            cache: false,
            type: "POST",
            url: "<%=path%>/user/complain/add",
            data: {
                uid: '${currentUser.id}',
                content: content,
                contactPhone: contactPhone,
            },
            async: false,
            error: function(request) {
                toastr.error("Server Connection Error..."+JSON.stringify(request));
            },
            success: function(res) {
                swal({
                	title: "提示",    
                	text: "提交成功，感谢您的反馈",    
                	timer: 2000,    
                	showConfirmButton: true
                },function(isConfirm){
                    if (isConfirm) {
                    	WeixinJSBridge.invoke('closeWindow', {}, function (res) {});
                	};
                });
                
            } 
        });
    }
    </script>
</body>
</html>
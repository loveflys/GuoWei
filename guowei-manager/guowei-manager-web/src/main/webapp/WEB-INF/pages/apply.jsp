<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
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

<style>
.flex-div a {
	display: flex;
	text-decoration: none;
}

.logo-icon {
	background-image: url('<%=path%>/res/home/assets/images/logo.png');
	background-size: cover;
	width: 40px;
	height: 40px;
	display: block;
	margin-right: 15px;
}

.vira-card-header img {
	width: 273px;
	height: 292px;
}
</style>
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
    <div id="menu-item" class="menu-item hide-menu">
            <div class="container">
                <ul>
                    <a href="index.html"><li>首页</li></a>
                    <a href="#about"><li>关于我们</li></a>
                    <a href="#expertise"><li>核心业务</li></a>
                    <a href="#contact"><li>联系我们</li></a>
                </ul>
            </div>
        </div>
        <div class="main">
            <header class="bg-img header">
                <nav class="navbar navbar-default navbar-vira">
                    <div class="container">
                        <div class="navigation-bar">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="logo flex-div">
                                        <a href="index.html">
                                            <span class="logo-icon"></span>
                                            微妙
                                        </a>
                                    </div>
                                </div>
                                <div class="col-xs-6 text-right">
                                    <div class="menu m">
                                        <a href="#"><span class="ion-navicon _ion-android-menu"></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
                <div class="container">
                    <div class="row">
                        <div class="intro-box">
                            <div class="intro">
                                <h1>微妙</h1>
                                <p>一阵美食风席卷办公室，我们把超市建在了您身边，美味瞬间触手可得！</p>
                                <a class="btn vira-btn" href="#contact">联系我们</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <section id="about" class="about section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2">
                            <h2 class="title">关于我们</h2>
                            <p>
                                微妙隶属于青岛果位网络科技有限公司, 微妙于2017年7月正式上线，主要用户定位为年轻白领人群，是基于办公室消费场景的垂直电商平台。
微妙商城是一个新锐的零食电商平台，以城市写字楼聚集区域的白领为主要目标人群，以办公室为主要消费场景，推出“一样一点”的办公室零食文化，倡导办公室零食新主张：精致小包装，吃出多花样。
                            </p>
                        </div>
                    </div>
                </div>
            </section>
            <section id="expertise" class="expert">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6 bg-img">
                            <div></div>
                        </div>
                        <div class="col-sm-5 section">
                            <h2 class="title">核心业务</h2>
                            <div id="expert-slider" class="owl-carousel">
                                <div class="item">
                                    <p>
                                        早上为了赶时间来不及吃早餐，有些人在路上买些带到公司去吃，而有些人连买早餐的时间也没有，只能饿着肚子上班。

    中午因为太忙或开会而错过了饭点，肚子饿得咕咕叫时，点个外卖还要等…

    下午困了，饿了，提不起神，也想吃点东西...

    晚上加班，饿了想吃点小零食垫下肚子，发现办公室什么吃的都没有，又不想晚上点外卖吃那么多…
                                    </p>
                                </div>
                                <div class="item">
                                    <p>
                                        微妙，为上班族解决了这些问题。

员工通过扫描货架上的二维码，选购零食，进行支付，即可拿走零食。让员工在上班时间也能方便地购买零食。
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="contact" class="contact section">
                <div class="container">
                    <h2 class="title">联系我们</h2>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="vira-card">
                                <div class="vira-card-header">
                                        <span class="fa fa-comments" aria-hidden="true"></span>
                                </div>
                                <div class="vira-card-content">
                                    <h3>微信</h3>
                                    <p>
                                        微妙vm
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="vira-card">
                                <div class="vira-card-header">
                                        <span class="fa fa-phone" aria-hidden="true"></span>
                                </div>
                                <div class="vira-card-content">
                                    <h3>联系电话</h3>
                                    <p>
                                        18669704568
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="vira-card">
                                <div class="vira-card-header">
                                        <span class="fa fa-paper-plane" aria-hidden="true"></span>
                                </div>
                                <div class="vira-card-content">
                                    <h3>邮箱</h3>
                                    <p>
                                        baozi@chenanyi.com
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <p>Copyright © 2017 QingDao GuoWei Technology Inc.</p>
                            <p>All Rights Reserved.</p>
                        </div>
                        <div class="col-sm-12">
                            <a style="font-size: 12px;font-style: normal;text-decoration: none;" href="<%=path%>/login">manage</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <script src="<%=path%>/res/home/assets/js/jquery-3.1.1.js"></script>
        <script src="<%=path%>/res/home/assets/js/bootstrap.min.js"></script>
        <script src="<%=path%>/res/home/assets/js/owl.carousel.min.js"></script>
        <script src="https://use.fontawesome.com/55b73bf748.js"></script>
        <script src="<%=path%>/res/home/assets/js/jquery.magnific-popup.js"></script>
        <script src="<%=path%>/res/home/assets/js/script.js"></script>
</body>
</html>
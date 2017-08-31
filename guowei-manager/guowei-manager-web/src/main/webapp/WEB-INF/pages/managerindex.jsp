<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/common.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <!--title-->
        <%@ include file="include/title.jsp" %>
        
        <!-- iCheck -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/iCheck/flat/blue.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/morris/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/datepicker/datepicker3.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/daterangepicker/daterangepicker.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="<%=path%>/res/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
        <link rel="stylesheet" href="<%=path%>/res/address.css">
        <style type="text/css">
            .modal-dialog { 
                position: absolute; 
                top: 0; 
                bottom: 0; 
                left: 0; 
                right: 0; 
            } 
            
            .modal-content { 
                /*overflow-y: scroll; */ 
                position: absolute; 
                top: 0; 
                bottom: 0; 
                width: 100%; 
            } 
            
            .modal-body { 
                overflow-y: scroll; 
                position: absolute; 
                top: 55px; 
                bottom: 65px; 
                width: 100%; 
            } 
            
            .modal-footer {
                position: absolute; 
                width: 100%; 
                bottom: 0; 
            }
        </style>
        
    </head>
    
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
	        <!--header-->
	        <%@ include file="include/header.jsp"%>
	
	        <!--menu-->
	        <%@ include file="include/menu.jsp"%>
			<div class="content-wrapper" style="min-height: 901px;">
			    <section class="content-header">
                <a href="<%=path%>/managerindex"><i class="fa fa-home"></i> <sp:message
                        code="sys.home" /></a> >
                </section>
				<section class="content">
					<div class="row">
						<div class="col-lg-3 col-xs-6">
							<div class="small-box bg-aqua">
								<div class="inner">
									<h3 id="todayamount"></h3>
									<p>今日营业额</p>
								</div>
								<div class="icon">
									<i class="ion ion-stats-bars"></i>
								</div>
								<a href="<%=path%>/orders" class="small-box-footer">更多 <i
									class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
						<div class="col-lg-3 col-xs-6">
							<div class="small-box bg-green">
								<div class="inner">
									<h3 id="toweekamount"></h3>
									<p>最近一周营业额</p>
								</div>
								<div class="icon">
									<i class="ion ion-stats-bars"></i>
								</div>
								<a href="<%=path%>/orders" class="small-box-footer">更多<i
									class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
						<div class="col-lg-3 col-xs-6">
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3 id="tomonthamount"></h3>
                                    <p>最近一月营业额</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<%=path%>/orders" class="small-box-footer">更多<i
                                    class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-xs-6">
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3 id="allamount"></h3>
                                    <p>总营业额</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<%=path%>/orders" class="small-box-footer">更多<i
                                    class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
						<div class="col-lg-3 col-xs-6">
							<!-- small box -->
							<div class="small-box bg-yellow">
								<div class="inner">
									<h3 id="newuser"></h3>
									<p>新注册用户</p>
								</div>
								<div class="icon">
									<i class="ion ion-person-add"></i>
								</div>
								<a href="<%=path%>/users" class="small-box-footer">更多<i
									class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
						<div class="col-lg-3 col-xs-6">
							<div class="small-box bg-red">
								<div class="inner">
									<h3 id="alluser">65</h3>			
									<p>总用户数</p>
								</div>
								<div class="icon">
									<i class="ion ion-person"></i>
								</div>
								<a href="<%=path%>/users" class="small-box-footer">更多<i
									class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
				          <div class="box box-primary">
				            <div class="box-header with-border">
				              <h3 class="box-title">年度营业额</h3>				
				              <div class="box-tools pull-right">
				                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
				                </button>
				                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
				              </div>
				            </div>
				            <div class="box-body" style="display: block;">
				              <div class="chart">
				                <div id="yearChart" style="width: 100%;height: 500px;"></div>
				              </div>
				            </div>
				          </div>	
				        </div>	
					</div>
					<div class="row">
					   <div class="col-md-12">
                            <div class="box box-danger">
                            <div class="box-header with-border">
                              <h3 class="box-title">月份营业额</h3>                
                              <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                              </div>
                            </div>
                            <div class="box-body">
                              <div id="monthChart" style="width: 100%;height: 500px;"></div>
                            </div>
                          </div>    
                        </div>
					</div>
				</section>
			</div>
	    </div>
        
        <script>
            window.param = {
            		
            }
            $(function () {
                _.templateSettings = {
                    evaluate    : /\[\[(.+?)\]\]/g,
                    interpolate : /\{\{(.+?)\}\}/g
                };
                getData();
            });
            function getData () {
	            $.ajax({
	                cache: false,
	                type: "POST",
	                url: "<%=path%>/getIndexData",
	                data: {
	                },
	                async: false,
	                error: function(request) {
	                    toastr.error("Server Connection Error...");
	                },
	                success: function(res) {
	                	$("#todayamount").html(res.TodayAmount + '<span>元</span>');
                        $("#toweekamount").html(res.ToweekAmount + '<span>元</span>');
                        $("#tomonthamount").html(res.TomonthAmount + '<span>元</span>');
                        $("#allamount").html(res.allAmount + '<span>元</span>');
	                	$("#newuser").html(res.newUser);
	                    $("#alluser").html(res.allUser);
	                    
	                    var yearChart = echarts.init(document.getElementById('yearChart'));
	                    var monthChart = echarts.init(document.getElementById('monthChart'));
	                    var yearoption = {
	                    	    title: {
	                    	        text: '月营业额'
	                    	    },
	                    	    tooltip : {
	                    	        trigger: 'axis',
	                    	        axisPointer: {
	                    	            type: 'cross',
	                    	            label: {
	                    	                backgroundColor: '#6a7985'
	                    	            }
	                    	        }
	                    	    },
	                    	    legend: {
	                    	        data:['月营业额']
	                    	    },
	                    	    toolbox: {
	                    	        feature: {
	                    	            saveAsImage: {}
	                    	        }
	                    	    },
	                    	    xAxis : [
	                    	        {
	                    	            type : 'category',
	                    	            boundaryGap : false,
	                    	            data : res.yeardatatitle
	                    	        }
	                    	    ],
	                    	    yAxis : [
	                    	        {
	                    	            type : 'value'
	                    	        }
	                    	    ],
	                    	    series : [
	                    	        {
	                    	            name:'月营业额',
	                    	            type:'line',
	                    	            stack: '总量',
	                    	            areaStyle: {normal: {}},
	                    	            data: res.yeardata
	                    	        }
	                    	    ]
	                    	};
	                    yearChart.setOption(yearoption);
	                    var monthoption = {
                                title: {
                                    text: '日营业额'
                                },
                                tooltip : {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        label: {
                                            backgroundColor: '#6a7985'
                                        }
                                    }
                                },
                                legend: {
                                    data:['日营业额']
                                },
                                toolbox: {
                                    feature: {
                                        saveAsImage: {}
                                    }
                                },
                                xAxis : [
                                    {
                                        type : 'category',
                                        boundaryGap : false,
                                        data : res.monthdatatitle
                                    }
                                ],
                                yAxis : [
                                    {
                                        type : 'value'
                                    }
                                ],
                                series : [
                                    {
                                        name:'日营业额',
                                        type:'line',
                                        stack: '总量',
                                        areaStyle: {normal: {}},
                                        data:res.monthdata
                                    }
                                ]
                            };
	                    monthChart.setOption(monthoption);
	                }
	            });
	        }
	        function bindAddr(id) {
	            
	        }
        </script>
        <script src="<%=path%>/res/home/assets/js/jquery-ui.min.js"></script>
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <script src="<%=path%>/res/home/assets/js/raphael-min.js"></script>
        <script src="<%=path%>/res/plugins/morris/morris.min.js"></script>
        <!-- Sparkline -->
        <script src="<%=path%>/res/plugins/sparkline/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="<%=path%>/res/plugins/knob/jquery.knob.js"></script>
        <!-- daterangepicker -->
        <script src="<%=path%>/res/home/assets/js/moment.min.js"></script>
        <script src="<%=path%>/res/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- datepicker -->
        <script src="<%=path%>/res/plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="<%=path%>/res/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <!-- Slimscroll -->
        <script src="<%=path%>/res/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
        <script src="<%=path%>/res/home/assets/js/underscore.min.js"></script>
        <!-- AdminLTE App -->
        <script src="<%=path%>/res/dist/js/app.min.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="<%=path%>/res/dist/js/pages/dashboard.js"></script>
        <script src="<%=path%>/res/plugins/echarts/echarts.simple.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="<%=path%>/res/dist/js/demo.js"></script>
    </body>
</html>
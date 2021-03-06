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
       		<%@ include file="include/header.jsp" %>
       		<%@ include file="include/menu.jsp" %>
			<div class="content-wrapper">
				<section class="content-header">
					<a href="<%=path%>/"><i class="fa fa-home"></i> <sp:message code="sys.home"/></a> > 
					<a href="<%=path%>/applys"><sp:message code="apply.list"/></a>&nbsp;&nbsp;<small><sp:message code="apply.list"/></small>
				</section>
			
				<!-- Main content -->
				<section class="content">
					<div class="row-fluid">
					
						<div class="pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-primary btn-sm" id="btn-re">
									<i class="fa fa-refresh"></i> <sp:message code="sys.refresh"/>
								</button>
							</div>
						</div>

						<div class="row">
							<form id="queryForm" action="<%=path%>/applys" method="post">
								<div class="col-xs-2">
									<input type="text" id="keyword" name="name" class="form-control input-sm"
										placeholder="<sp:message code="sys.keyword"/>">
								</div>
								<button type="button" class="btn btn-primary btn-sm" id="btn-query">
									<i class="fa fa-search"></i> <sp:message code="sys.query"/>
								</button>
							</form>
						</div>
					</div>
	                
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-body">
									<table id="dataTable" class="table table-striped table-bordered table-hover table-condensed" align="center">
										<thead>
											<tr class="info">
												<th><sp:message code="sys.no"/></th>
												<th><sp:message code="apply.companyName"/></th>
												<th><sp:message code="apply.companyAddr"/></th>
												<th><sp:message code="apply.contactName"/></th>
												<th><sp:message code="apply.contactPhone"/></th>												
												<th><sp:message code="sys.create.time"/></th>
                                                <th><sp:message code="sys.oper"/></th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</section>

			</div>
	
			<!--footer-->
	       	<%@ include file="include/footer.jsp" %>
			<div class="control-sidebar-bg"></div>
		</div>
		
		<!-- EditUser -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><sp:message code="apply.info"/>-<sp:message code="sys.edit"/></h4>
					</div>
					
					<div class="modal-body" >
						<form class="form-horizontal"  id="editForm" >
							<input type="hidden" class="form-control" name="id">
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="apply.companyName"/></label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="companyName" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="apply.companyAddr"/></label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" name="companyAddr" disabled="disabled"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="apply.contactName"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="contactName" readonly="readonly">
                                </div>
                            </div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="apply.contactPhone"/></label>
								<div class="col-sm-9">
									<input type="tel" class="form-control" name="contactPhone" readonly="readonly">
								</div>
							</div>							
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="sys.create.time"/></label>

								<div class="col-sm-9">
									<input type="tel" class="form-control" name="created" readonly="readonly">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	
		<!-- page script -->
		<script>
			$(function () {
				
				//页面消息处理
				var result = "${result}";
		  		var msg= "${msg}";
		  		if(result == 1){
		  			alert(msg);
		  		}
		  		
		  		
				
				var tables = $("#dataTable").dataTable({
			    	serverSide: true,//分页，取数据等等的都放到服务端去
			        processing: false,//载入数据的时候是否显示“载入中”
			        pageLength: 10,  //首次加载的数据条数
			        ordering: false,//排序操作在服务端进行，所以可以关了。
			        pagingType: "full_numbers",
			        autoWidth: false,
			        stateSave: true,//保持翻页状态，和tables.fnDraw(false);结合使用
			        searching: false,
			        ajax: {   //类似jquery的ajax参数，基本都可以用。
			        	type: "post",//后台指定了方式，默认get，外加datatable默认构造的参数很长，有可能超过get的最大长度。
			            url: "<%=path%>/user/getApplys",
			            dataSrc: "data",//默认data，也可以写其他的，格式化table的时候取里面的数据
	                    data: function (d) {//d是原始的发送给服务器的数据，默认很长。
	                        var param = {}; //因为服务端排序，可以新建一个参数对象
	                        param.draw = d.draw;
                            param.start = d.start;
                            param.length = d.length;
	                        var formData = $("#queryForm").serializeArray();//把form里面的数据序列化成数组
	                        formData.forEach(function (e) {
	                            param[e.name] = e.value;
	                        });
                        	return param;//自定义需要传递的参数。
			       		}
			    	},
	                columns: [//对应上面thead里面的序列
	                    //{"data": null,"width":"10px"},
	                    {"data": 'id'},
	               		{"data": 'companyName'}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列	               		
	                    {"data": 'companyAddr', defaultContent: ""},
	                    {"data": 'contactName', defaultContent: ""},
  	                    {"data": 'contactPhone', defaultContent: ""},
  	                    {"data": 'created', 
  	                    	"render":function(data,type,full,callback) {
  	                    		return moment(data).format('YYYY-MM-DD') 
	                    	}
	               		},
  	                  	{"data": null,"width":"60px"}
	                ],
	                //操作按钮
	                columnDefs: [
	                    /*{
		                    targets: 0,//编辑
		                    data: null,//下面这行，添加了编辑按钮和，删除按钮
		                    defaultContent: "<input type='checkbox' name='checkList'>"
		                },*/
		                {
		                    targets: -1,//编辑
		                    data: null,//下面这行，添加了编辑按钮和，删除按钮
		                    defaultContent: " <div class='btn-group'>"+
		                					//"<button id='infoRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i> </button>"+
		                    				"<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i></button>"+
		                    				"</div>"
		                }
	                ],
	              	//每加载完一行的回调函数
	                createdRow: function( row, data, index ) {
	                	console.log("加载完一行")
	                	//修改单元格样式
	    　　　　　　　　	//$('td', row).eq(5).css('font-weight',"bold").css("color","red");//获取到具体行具体格的元素
	                },
			        initComplete: function (setting, json) {
	                	//初始化完成之后替换原先的搜索框。
	                	console.log("初始化完成")
	                },
	              	//在每次table被draw完后调用
	                fnDrawCallback: function(){
	                	console.log("draw完成")
                		var api = this.api();
                		//获取到本页开始的条数
                	　　	var startIndex= api.context[0]._iDisplayStart;
                	　　	api.column(0).nodes().each(function(cell, i) {
                	　　　　	cell.innerHTML = startIndex + i + 1;
                	　　}); 
                	},
	                language: {
	                	lengthMenu: "",//不显示记录条数选择
	                  	//lengthMenu: '<select class="form-control input-xsmall">' + '<option value="5">5</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
	                  	processing: "<sp:message code='sys.load'/>",//处理页面数据的时候的显示
	                    paginate: {//分页的样式文本内容。
	                   		previous: "<",
	                     	next: ">",
	                     	first: "<<",
	                     	last: ">>"
	                    },
	                    zeroRecords: "<sp:message code='sys.nodata'/>",//table tbody内容为空时，tbody的内容。
	                    //下面三者构成了总体的左下角的内容。
	                    //info: "共 _PAGES_ 页，显示第 _START_ 到第 _END_ 条 ",//筛选之后得到 _TOTAL_ 条，初始 _MAX_ 条   左下角的信息显示，大写的词为关键字。
	                    info: "<sp:message code='sys.pages'/>",
	                    infoEmpty: "<sp:message code='sys.nodata'/>",//筛选为空时左下角的显示。0条记录
	                    infoFiltered: "",//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
	                   	sSearch: "<sp:message code='sys.keyword'/>：",
	                }
	            });
				//用户类型选择触发
				$("#area").on("change", function () {
					tables.fnDraw();
				});
				
				//查询按钮
				$("#btn-query").on("click", function () {
					tables.fnDraw(false);
				});
				
				//添加
	            $("#btn-add").on("click", function () {
	            	//tables.fnDraw();
	            });
				
	          	//批量删除
	            $("#btn-delAll").on("click", function () {
	            	tables.draw( false );
	            });
	          	
	         	//导出
	            $("#btn-export").on("click", function () {
	            	tables.fnDraw();
	            });
				
				//刷新
	            $("#btn-re").on("click", function () {
	            	tables.fnDraw(false);
	            });
				
	          	//checkbox全选
	            $("#checkAll").on("click", function () {
	                if ($(this).prop("checked") === true) {
	                    $("input[name='checkList']").prop("checked", $(this).prop("checked"));
	                    $('#dataTable tbody tr').addClass('selected');
	                } else {
	                    $("input[name='checkList']").prop("checked", false);
	                    $('#dataTable tbody tr').removeClass('selected');
	                }
	            });
	          	
	          	//修改 Model
				$('#dataTable tbody').on( 'click', '#editRow', function () {
					var data = tables.api().row($(this).parents('tr')).data();
					$("input[name=companyName]").val(data.companyName);
					$("textarea[name=companyAddr]").val(data.companyAddr);
					$("input[name=contactName]").val(data.contactName);
					$("input[name=contactPhone]").val(data.contactPhone);
					if (!data.created || data.created.length <= 0) {
						$("input[name=created]").val(new Date().getTime);
					} else {
						$("input[name=created]").val(data.created);
					}
					$("#editModal").modal("show");
					
		        });
			});
		</script>
		<script src="<%=path%>/res/home/assets/js/jquery-ui.min.js"></script>
		<script>
	  		$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script src="<%=path%>/res/home/assets/js/raphael-min.js"></script>
		<script src="<%=path%>/res/plugins/morris/morris.min.js"></script>
		<script src="<%=path%>/res/plugins/sparkline/jquery.sparkline.min.js"></script>
		<script src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<script src="<%=path%>/res/plugins/knob/jquery.knob.js"></script>
		<script src="<%=path%>/res/home/assets/js/moment.min.js"></script>
		<script src="<%=path%>/res/plugins/daterangepicker/daterangepicker.js"></script>
		<script src="<%=path%>/res/plugins/datepicker/bootstrap-datepicker.js"></script>
		<script src="<%=path%>/res/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="<%=path%>/res/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
		<script src="<%=path%>/res/dist/js/app.min.js"></script>
		<script src="<%=path%>/res/dist/js/pages/dashboard.js"></script>
		<script src="<%=path%>/res/dist/js/demo.js"></script>
	</body>
</html>

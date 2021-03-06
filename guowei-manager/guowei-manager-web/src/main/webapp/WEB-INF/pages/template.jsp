<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
<!--title-->
<%@ include file="include/title.jsp"%>

<!-- iCheck -->
<link rel="stylesheet" href="<%=path%>/res/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="<%=path%>/res/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="<%=path%>/res/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=path%>/res/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="<%=path%>/res/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

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

		<!-- Left side column. contains the logo and sidebar -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">

				<!-- 路径导航 -->
				<a href="<%=path%>/"><i class="fa fa-home"></i> <sp:message
						code="sys.home" /></a> > <a href="<%=path%>/templates"><sp:message
						code="menu.templates" /></a>&nbsp;&nbsp;<small><sp:message
						code="template.list" /></small>
				<!-- 
                    <ol class="breadcrumb">
                        <%@ include file="include/home.jsp" %>
                        <li class="active">商品管理</li>
                    </ol>
                     -->
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- 查询、添加、批量删除、导出、刷新 -->
				<div class="row-fluid">

					<div class="pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-primary btn-sm" id="btn-add">
								<i class="fa fa-plus"></i>
								<sp:message code="sys.add" />
							</button>
							<button type="button" class="btn btn-primary btn-sm" id="btn-re">
								<i class="fa fa-refresh"></i>
								<sp:message code="sys.refresh" />
							</button>
						</div>
					</div>

					<div class="row">
						<form id="queryForm" action="<%=path%>/templates" method="post">
							<div class="col-xs-2">
								<input type="text" id="keyword" name="name"
									class="form-control input-sm"
									placeholder="<sp:message code="sys.keyword"/>">
							</div>
							<button type="button" class="btn btn-primary btn-sm"
								id="btn-query">
								<i class="fa fa-search"></i>
								<sp:message code="sys.query" />
							</button>
						</form>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body">
								<table id="dataTable"
									class="table table-striped table-bordered table-hover table-condensed"
									align="center">
									<thead>
										<tr class="info">
											<!-- <td><input type="checkbox" id="checkAll"></td> -->
											<th><sp:message code="sys.no" /></th>
											<th><sp:message code="template.name" /></th>
											<th><sp:message code="sys.create.time" /></th>
											<th><sp:message code="sys.oper" /></th>
										</tr>
									</thead>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>

		</div>

		<!--footer-->
		<%@ include file="include/footer.jsp"%>
		<div class="control-sidebar-bg"></div>
	</div>

	<!-- EditTemplate -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message
								code="sys.close" /></span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<sp:message code="template.info" />
						-
						<sp:message code="sys.edit" />
					</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="editForm"
						action="<%=path%>/template/update" method="post">
						<input type="hidden" class="form-control" name="id">
						<input type="hidden" class="form-control" name="supplierid">
						<div class="form-group">
							<label for="inputName" class="col-sm-3 control-label"><sp:message
									code="template.name" /></label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name">
							</div>
						</div>
						<div class="form-group">
                            <label for="inputName" class="col-sm-3 control-label">供货商</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="supplierid" id="editsupplierid_container"  onchange="changesupplierid(this.options[this.options.selectedIndex].value)">
        
                                </select>
                            </div>
                        </div> 
						<div class="form-group">
							<label for="inputName" class="col-sm-3 control-label"><sp:message
									code="sys.create.time" /></label>

							<div class="col-sm-9">
								<input type="tel" class="form-control" name="created"
									readonly="readonly">
							</div>
						</div>
					</form>
				</div>
				<!-- modal-body END -->

				<div class="modal-footer">
					<button id="btn-submit" type="submit" class="btn btn-primary">
						<sp:message code="sys.submit" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- AddTemplate -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message
								code="sys.close" /></span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<sp:message code="template.info" />
						-
						<sp:message code="sys.add" />
					</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="addForm"
						action="<%=path%>/template/add" method="post">
						<input type="hidden" class="form-control" name="supplierid">
						<div class="form-group">
							<label for="inputName" class="col-sm-3 control-label"><sp:message
									code="template.name" /></label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name">
							</div>
						</div>
						<div class="form-group">
                            <label for="inputName" class="col-sm-3 control-label">供货商</label>
                            <div class="col-sm-9">
	                            <select class="form-control" name="supplierid" id="addsupplierid_container"  onchange="changesupplierid(this.options[this.options.selectedIndex].value)">
	    
	                            </select>
                            </div>
                        </div> 
					</form>
				</div>
				<!-- modal-body END -->

				<div class="modal-footer">
					<button id="btn-addsubmit" type="submit" class="btn btn-primary">
						<sp:message code="sys.submit" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- ManagerTemplate -->
	<div class="modal fade" id="managerModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message
								code="sys.close" /></span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<sp:message code="template.info" />
						-
						<sp:message code="sys.manager" />
					</h4>
				</div>

				<div class="modal-body">
					<input type="hidden" class="form-control" name="id">
					<div class="row">
						<div class="col-md-12" id="manager_body">
							
						</div>
					</div>
				</div>
				<!-- modal-body END -->
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">设置库存提醒</h4>
				      </div>
				      <div class="modal-body">
				        <p>当前库存: <span id="now_stock"></span></p>
				        <div class="form-group">                                                        
                            <label for="inputName" class="col-sm-3 control-label">铺货数量</label>
                            <div class="col-sm-9">
                                <input id="stock" type="number" class="form-control">
                            </div>
                        </div>
				        <div class="form-group">				            				            
                            <label for="inputName" class="col-sm-3 control-label">库存提醒数量</label>
                            <div class="col-sm-9">
                                <input id="warnstock" type="number" class="form-control">
                            </div>
                        </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="button" class="btn btn-primary" onclick="changeTemplate(true)">上架</button>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
	</div>
	<!-- page script -->
	<script type="template" id="supplierid_tpl">
            [[ for(var i=0; i< data.length; i++){ var item=data[i]; ]]
                [[ if (item.id == supplierid) { ]]
                    <option value="{{item.id}}" selected="selected">{{item.supplierName}}</option>
                [[ } else { ]]
                    <option value="{{item.id}}">{{item.supplierName}}</option>
                [[ } ]]
            [[ } ]]
    </script>
	<script type="template" id="proList_tpl">
        <tr>
          <th>图片</th>
          <th>名称</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
        [[ for(var i=0; i< data.length; i++){ var item=data[i]; ]]
        <tr>
          <td>
            <img src="{{item.image}}" width="50px" height="50px" />
          </td>
          <td>{{item.title}}</td>
          <td><span class="badge bg-red">￥{{item.price}}</span></td>
          <td  data-toggle="modal" data-target="#myModal" onclick="changeTemplateWarnStock({{huojia}}, {{item.id}}, {{item.stock}})"><i class="fa fa-plus"></i></td>
        </tr>        
        [[ } ]]
    </script>
    <script type="template" id="selectproList_tpl">
        <tr>
          <th>图片</th>
          <th>名称</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
        [[ for(var i=0; i< data.length; i++){ var item=data[i]; ]]
        <tr>
          <td>
            <img src="{{item.proimage}}" width="50px" height="50px" />
          </td>
          <td>{{item.proname}}</td>
          <td><span class="badge bg-red">￥{{item.proprice}}</span></td>
          <td onclick="changeTemplate(false, {{item.id}})"><i class="fa fa-minus"></i></td>
        </tr>        
        [[ } ]]
    </script>
    <script type="template" id="managerBody_tpl">
        <div class="nav-tabs-custom">
        [[ if (storages && storages.length > 0) { ]]
                                <ul class="nav nav-tabs">
                                    [[ for(var i=0,length=storages.length; i< length; i++) { var item = storages[i]; ]]
                                    <li class="{{window.param.index?(window.param.index == item.id ? 'active':''):(i==0?'active':'')}}"><a href="#tab_{{i+1}}" onclick="window.param.index = {{item.id}}" data-toggle="tab"
                                        aria-expanded="true">{{item.storageName}}</a></li>
                                    [[ } ]]
                                </ul>
        [[ } ]]
                                <div class="tab-content">
                                    [[ for(var i=0,length=storages.length; i< length; i++) { var item = storages[i]; ]]        
                                    <div class="tab-pane {{window.param.index?(window.param.index == item.id ? 'active':''):(i==0?'active':'')}}" id="tab_{{i+1}}">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="box">
                                                    <div class="box-header with-border">
                                                        <h3 class="box-title">已有商品库</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body">
                                                        <table class="table table-bordered">
                                                            <tbody id="{{i+1}}_ProContainer">
                                                                <tr>
          <th>图片</th>
          <th>名称</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
        [[ for(var index=0; index< window.param.tempList.length; index++){ var it=window.param.tempList[index]; ]]
        <tr>
          <td>
            <img src="{{it.image}}" width="50px" height="50px" />
          </td>
          <td>{{it.title}}</td>
          <td><span class="badge bg-red">￥{{it.price}}</span></td>
          <td  data-toggle="modal" data-target="#myModal" onclick="changeTemplateWarnStock({{item.id}}, {{it.id}}, {{it.stock}})"><i class="fa fa-plus"></i></td>
        </tr>        
        [[ } ]]
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">{{item.storageName}}</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="{{i+1}}_SelectProContainer">
                                                                <tr>
          <th>图片</th>
          <th>名称</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
        [[ for(var indexs=0; indexs < window.param.tempProList.length; indexs++){ var itx=window.param.tempProList[indexs]; ]]
        [[ if (itx.storageracks == item.id) { ]]
        <tr>
          <td>
            <img src="{{itx.proimage}}" width="50px" height="50px" />
          </td>
          <td>{{itx.proname}}</td>
          <td><span class="badge bg-red">￥{{itx.proprice}}</span></td>
          <td onclick="changeTemplate(false, {{itx.id}})"><i class="fa fa-minus"></i></td>
        </tr>     
        [[ } ]]    
        [[ } ]]
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    [[ } ]]
                                </div>
                            </div>
    </script>
	<script>
    window.param = {
			  id: '', 
    		  proList: [],
    		  tempList: [],
			   tempProList: [],
			   storages: [],
               pid: '',
               sid: '',
               huojia: '',
               index: '',
            }
            $(function () {
            	_.templateSettings = {
                        evaluate    : /\[\[(.+?)\]\]/g,
                        interpolate : /\{\{(.+?)\}\}/g
                    };
                //页面消息处理
                var result = "${result}";
                var msg= "${msg}";
                if(result == 1){
                    alert(msg);
                }
                
                var level = ${currentUser.level};
                
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
                        url: "<%=path%>/template/getData",
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
                        {"data": 'name'}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列     
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
                                            (level!=1?"<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i></button>":"")+
                                            "<button id='managerRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-gears'></i></button>"+
                                            (level!=1?"<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i></button></div>":"")
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
                	var data = tables.api().row($(this).parents('tr')).data();
                    $("#addForm input[name=name]").val("");
                    getAddSupplierData();
                    $("#addModal").modal("show");
                });
                
                $("#btn-manager").on("click", function () {
                    $("#managerModal").modal("show");
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
                    $("input[name=id]").val(data.id);
                    window.param.supplierid = data.supplierid;
                    getEditSupplierData();
                    $("#editForm input[name=name]").val(data.name);
                    $("#editForm input[name=supplierid]").val(data.supplierid);
                    $("#editModal").modal("show");
                    
                });
                //管理 Model
                $('#dataTable tbody').on( 'click', '#managerRow', function () {
                    var data = tables.api().row($(this).parents('tr')).data();
                    $("input[name=id]").val(data.id);
                    window.param.id = data.id;
                    window.param.sid = data.supplierid;
                    getData();                    
                    $("#managerModal").modal("show");                    
                });
                
                $("#btn-submit").on("click", function(){
                    var url = "<%=path%>/template/update";
                    $.ajax({
                        cache: false,
                        type: "POST",
                        url: url,
                        data:$("#editForm").serialize(),
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error...");
                        },
                        success: function(data) {
                            if(data.status == 1){
                                $("#editModal").modal("hide");
                                toastr.success("<sp:message code='sys.oper.success'/>");
                                tables.fnDraw(false);
                            }else{
                                toastr.error("<sp:message code='sys.oper.fail'/>");
                            }
                        }
                    });
                });
                
                $("#btn-addsubmit").on("click", function(){
                    var url = "<%=path%>/template/add";
                    $.ajax({
                        cache: false,
                        type: "POST",
                        url: url,
                        data:$("#addForm").serialize(),
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error...");
                        },
                        success: function(data) {
                            if(data.status == 1){
                                $("#addModal").modal("hide");
                                toastr.success("<sp:message code='sys.oper.success'/>");
                                tables.fnDraw(false);
                            }else{
                                toastr.error("<sp:message code='sys.oper.fail'/>");
                            }
                        }
                    });
                });
                
                //删除
                $('#dataTable tbody').on( 'click', '#delRow', function () {
                    var data = tables.api().row($(this).parents('tr')).data();
                    if(confirm("是否确认删除这条信息?")){
                        $.ajax({
                            url:'<%=path%>/template/del/'+data.id,
                            type:'delete',
                            dataType: "json",
                            //timeout:"3000",
                            cache:"false",
                            success:function(data){
                                if(data.status == 1){
                                    //var $toast = toastr['info']('<sp:message code='sys.oper.success'/>');
                                    toastr.success("<sp:message code='sys.oper.success'/>");
                                    tables.api().row().remove().draw(false);//删除这行的数据
                                    //tables.fnDraw();
                                    //window.location.reload();//重新刷新页面，还有一种方式：tables.draw(false);(这是不刷新，重新初始化插件，但是做删除时候，老有问题)
                                }else{
                                    toastr.error(data.msg);
                                }
                            },
                            error:function(err){
                                toastr.error("Server Connection Error...");
                            }
                        });
                    }
                });
            });
    function getEditSupplierData () {
    	$.ajax({
            cache: false,
            type: "POST",
            url: "<%=path%>/supplier/getAllData",
            data: {},
            async: false,
            error: function(request) {
                toastr.error("Server Connection Error...");
            },
            success: function(res) {
            	$("#editModal input[name=supplierid]").val(window.param.supplierid);
                $("#editsupplierid_container").html(_.template($("#supplierid_tpl").html())({
                    "data": res.data,
                    "supplierid": window.param.supplierid
                }));
            }
        });
    }
    function getAddSupplierData () {
    	$.ajax({
            cache: false,
            type: "POST",
            url: "<%=path%>/supplier/getAllData",
            data: {},
            async: false,
            error: function(request) {
                toastr.error("Server Connection Error...");
            },
            success: function(res) {
                $("#addModal input[name=supplierid]").val(res.data[0].id);
                $("#addsupplierid_container").html(_.template($("#supplierid_tpl").html())({
                    "data": res.data,
                    "supplierid": window.param.supplierid
                }));
            }
        });
    }
    function changesupplierid(id) {
        $("#addModal input[name=supplierid]").val(id);
        $("#editModal input[name=supplierid]").val(id);
        window.param.supplierid = id;
    }
    function getData() {
    	var id = window.param.id;
    	$.ajax({
            cache: false,
            type: "POST",
            url: "<%=path%>/product/getAllData",
            data: {},
            async: false,
            error: function(request) {
                toastr.error("Server Connection Error...");
            },
            success: function(res) {
                window.param.proList = res.data;
                window.param.tempList = [];
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "<%=path%>/template/getProData",
                    data: {
                        tid: window.param.id
                    },
                    async: false,
                    error: function(request) {
                        toastr.error("Server Connection Error...");
                    },
                    success: function(resp) {
                        window.param.tempProList = resp.data;
                        $.ajax({
                            cache: false,
                            type: "POST",
                            url: "<%=path%>/supplier/getStorageData",
                            data: {
                                id: window.param.sid
                            },
                            async: false,
                            error: function(request) {
                                toastr.error("Server Connection Error...");
                            },
                            success: function(resp) {
                                window.param.storages = resp.data;
                                
                                for(var item of window.param.proList) {
                                	var has = false;
                                	for(var it of window.param.tempProList) {
                                		if (it.pid == item.id) {
                                			has = true;
                                		}
                                	}
                                	if (!has) {
                                		window.param.tempList.push(item);
                                	}
                                }
                                
                                _.templateSettings = {
                                    evaluate    : /\[\[(.+?)\]\]/g,
                                    interpolate : /\{\{(.+?)\}\}/g
                                };
                                bindData();
                            }
                        });
                        
                    }
                });
                
                
            }
        });
    }
            function bindData() {
            	$("#manager_body").html(_.template($("#managerBody_tpl").html())({
                    "storages": window.param.storages
                }));
            }
            function changeTemplateWarnStock(huojia, id, stock) {
            	window.param.pid = id;
            	window.param.huojia = huojia;
            	$("#now_stock").html(stock);
            }
            function changeTemplate(isplus, id) {
            	if (isplus) {
            		var stock = Number($("#stock").val());
            		var warnstock = Number($("#warnstock").val());
            		if(warnstock >= stock) {
            			toastr.error("库存提醒必须小于铺货数量");
            			return;
            		}
            		var has = false;
            		for(var item of window.param.tempProList) {
            			if (window.param.pid == item.pid) {
            				toastr.error("该商品已在货架中");
            				has = true;
            			}
            		}
            		if (has) {
            			return;
            		}
            		$.ajax({
                        cache: false,
                        type: "POST",
                        url: "<%=path%>/template/addProData",
                        data: {
                            tid: window.param.id,
                            huojia: window.param.huojia,
                            pid: window.param.pid,
                            stock: $("#stock").val(),
                            warnstock: $("#warnstock").val()
                        },
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error...");
                        },
                        success: function(resp) {
                        	toastr.success("<sp:message code='sys.oper.success'/>");
                        	getData();
                        	$("#myModal").modal('hide');
                        }
                    });
            	} else {
            		$.ajax({
                        cache: false,
                        type: "POST",
                        url: "<%=path%>/template/deleteProData",
                        data: {
                            id: id
                        },
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error...");
                        },
                        success: function(resp) {
                            getData();
                        }
                    });
            	}
            }
        </script>

	<!-- jQuery UI 1.11.4 -->
	<script src="<%=path%>/res/home/assets/js/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
	<script
		src="<%=path%>/res/home/assets/js/raphael-min.js"></script>
	<script src="<%=path%>/res/plugins/morris/morris.min.js"></script>
	<!-- Sparkline -->
	<script src="<%=path%>/res/plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script
		src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="<%=path%>/res/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="<%=path%>/res/plugins/knob/jquery.knob.js"></script>
	<!-- daterangepicker -->
	<script
		src="<%=path%>/res/home/assets/js/moment.min.js"></script>
	<script src="<%=path%>/res/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script src="<%=path%>/res/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="<%=path%>/res/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script src="<%=path%>/res/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=path%>/res/dist/js/app.min.js"></script>

	<script src="<%=path%>/res/home/assets/js/underscore.min.js"></script>

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<%=path%>/res/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=path%>/res/dist/js/demo.js"></script>
</body>
</html>
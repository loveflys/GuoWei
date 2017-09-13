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
		    th {
		      text-align: center;
		    }
		    td {
		        vertical-align: middle !important;
		        text-align: center;
		    }
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
					<a href="<%=path%>/companys"><sp:message code="menu.companys"/></a>&nbsp;&nbsp;<small><sp:message code="company.list"/></small>
				</section>
			
				<!-- Main content -->
				<section class="content">
					<!-- 查询、添加、批量删除、导出、刷新 -->
					<div class="row-fluid">
					
						<div class="pull-right">
							<div class="btn-group">
							    <button type="button" class="btn btn-primary btn-sm"  id="btn-add">
                                    <i class="fa fa-plus"></i> <sp:message code="sys.add"/>
                                </button>
								<button type="button" class="btn btn-primary btn-sm" id="btn-re">
									<i class="fa fa-refresh"></i> <sp:message code="sys.refresh"/>
								</button>
							</div>
						</div>

						<div class="row">
							<form id="queryForm" action="<%=path%>/companys" method="post">
								<div class="col-xs-2">
									<input type="text" id="keyword" name="companyName" class="form-control input-sm"
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
												<!-- <td><input type="checkbox" id="checkAll"></td> -->
												<th><sp:message code="sys.no"/></th>
												<th><sp:message code="company.mid"/></th>
												<th><sp:message code="company.templateId"/></th>
												<th><sp:message code="company.companyName"/></th>
												<th><sp:message code="company.companyAddr"/></th>
												<th><sp:message code="company.companyContactname"/></th>
												<th><sp:message code="company.companyContactposition"/></th>												
												<th><sp:message code="company.companyContactphone"/></th>
												<th><sp:message code="company.companyContactwechat"/></th>
                                                <th><sp:message code="company.created"/></th>
                                                <th><sp:message code="company.purchased"/></th>
                                                <th><sp:message code="company.did"/></th>
                                                <th><sp:message code="sys.oper"/></th>
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
	       	<%@ include file="include/footer.jsp" %>
			<div class="control-sidebar-bg"></div>
		</div>
		
		<!-- EditCompany -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><sp:message code="company.info"/>-<sp:message code="sys.edit"/></h4>
					</div>
					
					<div class="modal-body" >
						<form class="form-horizontal"  id="editForm" action="<%=path%>/company/update" method="post">
							<input type="hidden" class="form-control" name="id">
							<input type="hidden" class="form-control" name="mid">
                            <input type="hidden" class="form-control" name="templateId">
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.mid"/></label>
                                <div class="col-sm-9">
                                <select class="form-control" name="mid" id="editmid_container"  onchange="changeMid(this.options[this.options.selectedIndex].value)">
    
                                </select>
                                </div>
                            </div>  
                            
                            <div class="form-group">
                              <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.templateId"/></label>
                              <div class="col-sm-9">
	                              <select class="form-control" name="templateId" id="edittemplate_container"  onchange="changeTemplate(this.options[this.options.selectedIndex].value)">
	
	                              </select>
                              </div>
                            </div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyName"/></label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="companyName">
								</div>
							</div>
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyAddr"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyAddr">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactname"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactposition"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactposition">
                                </div>
                            </div>
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="com.con.tel"/></label>
                                <div class="col-sm-9">
                                    <input type="tel" class="form-control" name="companyContactphone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactwechat"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactwechat">
                                </div>
                            </div>					
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.did"/></label>
                                
                                <input type="hidden" class="form-control" name="did">
                                <div class="col-sm-9" id="edit-form-address">
                                    
                                </div>
                            </div>
						</form>
					</div>
					<!-- modal-body END -->
					
					<div class="modal-footer">
						<button id="btn-submit" type="submit" class="btn btn-primary"><sp:message code="sys.submit"/></button>
					</div>
				</div>
			</div>
		</div>
	    
	    
	    <!-- AddCompany -->
        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" >
                <div class="modal-content">
                
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel"><sp:message code="company.info"/>-<sp:message code="sys.add"/></h4>
                    </div>
                    
                    <div class="modal-body" >
                        <form class="form-horizontal"  id="addForm" action="<%=path%>/company/add" method="post">
                            <input type="hidden" class="form-control" name="mid">
                            <input type="hidden" class="form-control" name="templateId">
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.mid"/></label>
                                <div class="col-sm-9">
	                            <select class="form-control" name="mid" id="addmid_container"  onchange="changeMid(this.options[this.options.selectedIndex].value)">
	
	                            </select>
	                            </div>
                            </div>  
                            
                            <div class="form-group">
                              <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.templateId"/></label>
                              <div class="col-sm-9">
                              <select class="form-control" name="templateId" id="addtemplate_container"  onchange="changeTemplate(this.options[this.options.selectedIndex].value)">

                              </select>
                              </div>
                            </div>   
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyName"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyAddr"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyAddr">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactname"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactposition"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactposition">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="com.con.tel"/></label>
                                <div class="col-sm-9">
                                    <input type="tel" class="form-control" name="companyContactphone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.companyContactwechat"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyContactwechat">
                                </div>
                            </div>             
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="company.did"/></label>
                                <input type="hidden" class="form-control" name="did">
                                <div class="col-sm-9" id="add-form-address">
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- modal-body END -->
                    
                    <div class="modal-footer">
                        <button id="btn-addsubmit" type="submit" class="btn btn-primary"><sp:message code="sys.submit"/></button>
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
                        <div class="col-md-12">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab_1" data-toggle="tab"
                                        aria-expanded="true">第一层货架</a></li>
                                    <li class=""><a href="#tab_2" data-toggle="tab"
                                        aria-expanded="false">第二层货架</a></li>
                                    <li class=""><a href="#tab_3" data-toggle="tab"
                                        aria-expanded="false">第三层货架</a></li>
                                    <li class=""><a href="#tab_4" data-toggle="tab"
                                        aria-expanded="false">第四层货架</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_1">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">第一层货架商品</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="firstSelectProContainer">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab_2">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">第二层货架商品</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="secondSelectProContainer">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab_3">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">第三层货架商品</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="thirdSelectProContainer">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab_4">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">第四层货架商品</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="forthSelectProContainer">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab_5">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <div class="box-header">
                                                        <h3 class="box-title">雀巢专柜</h3>
                                                    </div>
                                                    <!-- /.box-header -->
                                                    <div class="box-body no-padding">
                                                        <table class="table">
                                                            <tbody id="fiveSelectProContainer">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                    </div>
                </div>
                <!-- modal-body END -->
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" onclick="$('#myModal').modal('hide')" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">商品补货</h4>
                      </div>
                      <div class="modal-body">
                        <p>当前库存: <span id="now_stock"></span></p>
                        <div class="form-group">                                                        
                            <label for="inputName" class="col-sm-3 control-label">补货数量</label>
                            <div class="col-sm-9">
                                <input id="stock" type="number" class="form-control">
                            </div>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" onclick="$('#myModal').modal('hide')">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="addCPStock()">确定</button>
                      </div>
                    </div>
                  </div>
                </div>
                
                <!-- Modal -->
                <div class="modal fade" id="showModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" onclick="$('#showModal').modal('hide')" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel"><span id="showModalcompanyName"></span> -- 公司扫码二维码</h4>
                      </div>
                      <div class="modal-body">
                        <div class="form-group">                                                        
                            <div id="show-qrcode" style="display: flex;align-items: center;justify-content: center;"></div>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" onclick="$('#showModal').modal('hide')">关闭</button>
                      </div>
                    </div>
                  </div>
                </div>
        <script type="template" id="template_tpl">
            [[ for(var i=0; i< data.length; i++){ var item=data[i] ]]
                [[ if (item.id == tid) { ]]
                    <option value="{{item.id}}" selected="selected">{{item.name}}</option>
                [[ } else { ]]
                    <option value="{{item.id}}">{{item.name}}</option>
                [[ } ]]
            [[ } ]]
        </script>
        <script type="template" id="mid_tpl">
            [[ for(var i=0; i< data.length; i++){ var item=data[i] ]]
                [[ if (item.id == mid) { ]]
                    <option value="{{item.id}}" selected="selected">{{item.name}}</option>
                [[ } else { ]]
                    <option value="{{item.id}}">{{item.name}}</option>
                [[ } ]]
            [[ } ]]
        </script>
        <script type="template" id="address_tpl">
            <div class="dropdown">
               <a role="button" data-toggle="dropdown" class="btn btn-primary selected-area">
                    {{(selected && selected.length > 0)?selected:'选择地址'}} <span class="caret"></span>
               </a>
               <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                    [[ for(var i=0, length1 = data.length; i< length1; i++){ var province=data[i] ]]
                        <li class="dropdown-submenu">
                             <a tabindex="-1" href="javascript:selectArea('{{province.id}}', '{{province.name}}');;">{{province.name}}</a>
                             [[ if (province && province.sub && province.sub.length > 0) { ]]                             
                             <ul class="dropdown-menu">
                                [[ for(var j=0, length2 = province.sub.length; j< length2; j++){ var city=province.sub[j]; ]]
                                <li class="dropdown-submenu">
                                    <a href="javascript:selectArea('{{city.id}}', '{{city.name}}');">{{city.name}}</a>
                                    [[ if (city && city.sub && city.sub.length > 0) { ]]
                                    <ul class="dropdown-menu">
                                        [[ for(var k=0, length3 = city.sub.length; k< length3; k++){ var area=city.sub[k]; ]]
                                        <li><a href="javascript:selectArea('{{area.id}}', '{{area.name}}');">{{area.name}}</a></li>
                                        [[ } ]]
                                    </ul>
                                    [[ } ]]
                                </li>
                                <li class="divider"></li>
                                [[ } ]]
                            </ul>
                            [[ } ]]
                        </li>
                    [[ } ]]
                </ul>
            </div>
        </script>
        <script type="template" id="selectproList_tpl">
            <tr>
                <th>图片</th>
                <th>名称</th>
                <th>价格</th>
                <th>库存</th>
                <th>库存提醒</th>
                <th>补货</th>
            </tr>
            [[ for(var i=0; i< data.length; i++){ var item=data[i]; ]]
                <tr>
                    <td>
                        <img src="{{item.proimage}}" width="50px" height="50px" />
                    </td>
                    <td>{{item.proname}}</td>
                    <td><span class="badge bg-red">￥{{item.proprice}}</span></td>
                    <td>{{item.stock}}</td>
                    <td>{{item.warnstock}}</td>
                    <td onclick="showCPStock({{item.companyId}}, {{item.id}}, {{item.pid}}, {{item.stock}})"><i class="fa fa-plus-square"></i></td>
                </tr>        
            [[ } ]]
        </script>
		<!-- page script -->
		<script>
		window.param = {
				id: '',
				templateId: '',
				pid: '',
				cpid: '',
				mid: '',
				area: {
					name: '',
					id: ''
				},
				allstock: 0,
				province: [],
				addr: [],
				firstProList: [],
                secondProList: [],
                thirdProList: [],
                forthProList: [],
                fiveProList: [],
		  }
			$(function () {
				_.templateSettings = {
                    evaluate    : /\[\[(.+?)\]\]/g,
                    interpolate : /\{\{(.+?)\}\}/g
                };
				getAllAddr();
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
			            url: "<%=path%>/company/getComplateData",
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
	                    {"data": 'mName', defaultContent: ""},
	                    {"data": 'tName', defaultContent: ""},
	               		{"data": 'companyName', defaultContent: ""}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列	               		
	                    {"data": 'companyAddr', defaultContent: ""},
	                    {"data": 'companyContactname', defaultContent: ""},
  	                    {"data": 'companyContactposition', defaultContent: ""},
  	                    {"data": 'companyContactphone', defaultContent: ""},
  	                    {"data": 'companyContactwechat', defaultContent: ""},
  	                    {"data": 'created', 
  	                    	"render":function(data,type,full,callback) {
  	                    		return moment(data).format('YYYY-MM-DD') 
	                    	}
	               		},
	               		{"data": 'purchased', 
                            "render":function(data,type,full,callback) {
                                return moment(data).format('YYYY-MM-DD') 
                            }
                        },
                        {"data": 'dname', defaultContent: ""},
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
		                                    "<button id='showRow' class='btn btn-primary btn-sm' title='查看二维码' type='button'><i class='fa fa-eye'></i></button>"+
		                    				"<button id='editRow' class='btn btn-primary btn-sm' title='编辑' type='button'><i class='fa fa-edit'></i></button>"+
		                    				"<button id='managerRow' class='btn btn-primary btn-sm' title='管理公司产品' type='button'><i class='fa fa-gears'></i></button>"+
		                    				"<button id='delRow' class='btn btn-primary btn-sm' title='删除公司' type='button'><i class='fa fa-trash-o'></i></button></div>"
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
	                	console.log("初始化完成");
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
	            	$("input[name=mid]").val("");
	            	$("input[name=templateId]").val("");
	            	getAddData();
                    $("#addModal input[name=companyName]").val("");
                    $("input[name=companyAddr]").val("");
                    $("input[name=companyContactname]").val("");
                    $("input[name=companyContactposition]").val("");
                    $("input[name=companyContactphone]").val("");
                    $("input[name=companyContactwechat]").val("");
                    $("input[name=did]").val("");
                    bindAddr();
                    $("#addModal").modal("show");      
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
					window.param.id = data.id;
					window.param.templateId = data.templateId;
					window.param.mid = data.mid;
					getEditData();
					$("input[name=mid]").val(data.mid);
					$("input[name=templateId]").val(data.templateId);
					$("#editModal input[name=companyName]").val(data.companyName);
					$("input[name=companyAddr]").val(data.companyAddr);
					$("input[name=companyContactname]").val(data.companyContactname);
					$("input[name=companyContactposition]").val(data.companyContactposition);
					$("input[name=companyContactphone]").val(data.companyContactphone);
					$("input[name=companyContactwechat]").val(data.companyContactwechat);
                    $("input[name=did]").val(data.did);
                    bindAddr(data.did);
					$("#editModal").modal("show");					
		        });
	          	
				//管理 Model
                $('#dataTable tbody').on( 'click', '#managerRow', function () {
                    var data = tables.api().row($(this).parents('tr')).data();
                    $("#managerRow input[name=id]").val(data.id);
                    window.param.id = data.id;
                    getData(); 
                    $("#managerModal").modal("show");                    
                });
				
                $('#dataTable tbody').on( 'click', '#showRow', function () {
                    var data = tables.api().row($(this).parents('tr')).data();
                    $("#showModalcompanyName").text(data.companyName);
                    var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8563cf7cd5154a95&redirect_uri=http%3A%2F%2Fwww.qingdaoguowei.com%2Fapi%2Foauth&response_type=code&scope=snsapi_userinfo&state=company%2F"+ data.id +"#wechat_redirect"; //任意内容 ；
                    
                    $.ajax({
                        cache: false,
                        type: "POST",
                        url: "<%=path%>/wechat/getShortUrl",
                        data: {
                        	url: url
                        },
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error..."+JSON.stringify(request));
                        },
                        success: function(res) {
                        	if (res.errcode == 0) {
	                        	$("#show-qrcode").empty();
	                            $("#show-qrcode").qrcode(res.short_url);
	                            $('#showModal').modal('show');
                        	}
                        }
                    });             
                });
	          	
				$("#btn-submit").on("click", function(){
					var url = "<%=path%>/company/update";
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
                    var url = "<%=path%>/company/add";
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
		                    url:'<%=path%>/company/del/'+data.id,
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
		                        	toastr.error("<sp:message code='sys.oper.success'/>");
		                        }
		                    },
		                    error:function(err){
		                    	toastr.error("Server Connection Error...");
		                    }
		                });
		            }
		        });
			});
		function getData() {
			window.param.firstProList = [];
            window.param.secondProList = [];
            window.param.thirdProList = [];
            window.param.forthProList = [];
	        var id = window.param.id;
	        $.ajax({
                cache: false,
                type: "POST",
                url: "<%=path%>/company/getProData",
                data: {
                    id: window.param.id
                },
                async: false,
                error: function(request) {
                    toastr.error("Server Connection Error...");
                },
                success: function(resp) {
                    console.log(JSON.stringify(resp.data));
                    for(var item of resp.data) {
                        if (item.storageracks == 1) {
                            window.param.firstProList.push(item);
                        } else if (item.storageracks == 2) {
                            window.param.secondProList.push(item);
                        } else if (item.storageracks == 3) {
                            window.param.thirdProList.push(item);
                        } else if (item.storageracks == 4) {
                            window.param.forthProList.push(item);
                        } else {
                            window.param.fiveProList.push(item);
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
	            function bindData() {	                
	                $("#firstSelectProContainer").html(_.template($("#selectproList_tpl").html())({
	                    "data": window.param.firstProList,
	                    "huojia": 1,
	                }));
	                $("#secondSelectProContainer").html(_.template($("#selectproList_tpl").html())({
	                    "data": window.param.secondProList,
	                    "huojia": "2",
	                }));
	                $("#thirdSelectProContainer").html(_.template($("#selectproList_tpl").html())({
	                    "data": window.param.thirdProList,
	                    "huojia": "3",
	                }));
	                $("#forthSelectProContainer").html(_.template($("#selectproList_tpl").html())({
	                    "data": window.param.forthProList,
	                    "huojia": "4",
	                }));
	                $("#fiveSelectProContainer").html(_.template($("#selectproList_tpl").html())({
                        "data": window.param.fiveProList,
                        "huojia": "5",
                    }));
	            }
	            function showCPStock (id, cpid, pid, stock) {
	            	window.param.id = id;
	            	window.param.cpid = cpid;
	            	window.param.pid = pid;
	            	$.ajax({
                        cache: false,
                        type: "POST",
                        url: "<%=path%>/product/getDetail",
                        data: {
                            id: pid
                        },
                        async: false,
                        error: function(request) {
                            toastr.error("Server Connection Error...");
                        },
                        success: function(resp) {
                        	window.param.allstock = resp.stock;
                            $("#now_stock").html(resp.stock);
                            $('#myModal').modal('show');
                        }
                    });
	            }
	            function addCPStock () {
	            	var stock = Number($("#stock").val());
                    var allstock = Number(window.param.allstock);
                    if(allstock < stock) {
                        toastr.error("库存不足，无法进行补货");
                        return;
                    }
                    $.ajax({
                        cache: false,
                        type: "POST",
                        url: "<%=path%>/company/changePro",
                        data: {
                            id: window.param.cpid,
                            addstock: $("#stock").val()
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
	            }
		    function selectArea (id, name) {
		    	$("input[name=did]").val(id);
		    	$(".selected-area").html(name + '<span class="caret"></span>');
		    }
		    function getAllAddr () {
		    	$.ajax({
                    cache: false,
                    type: "POST",
                    url: "<%=path%>/division/getAllData",
                    data: {},
                    async: false,
                    error: function(request) {
                        toastr.error("Server Connection Error...");
                    },
                    success: function(res) {
                    	window.param.addr = res.data;
                    	var province = [];
                        for (var item of res.data) {
                        	if (item.level == 1) {
                        		//省份，判断是否有下级
                        		item.sub = [];
                        		for (var it of res.data) {
                        			if (it.pid == item.id) {
                        				//市，判断是否有下级
                        				it.sub = [];
                        				for (var i of res.data) {
                        					if (i.pid == it.id) {
                        						//县/区
                        						it.sub.push(i);
                        					}
                        				}
                        				item.sub.push(it);
                        			}
                        		}
                        		province.push(item);
                        	}
                        }
                        window.param.province = province;
                    }
                });
		    }
		    function bindAddr(id) {
		    	if (id) {
		    		var selected = "";
		    		for (var item of window.param.addr) {
		    			if (item.id == id) {
		    				selected = item.name;
		    			}
		    		}
		    		$("#edit-form-address").html(_.template($("#address_tpl").html())({
                        "data": window.param.province,
                        "selected": selected
                    }));
		    	} else {
			    	$("#add-form-address").html(_.template($("#address_tpl").html())({
	                    "data": window.param.province,
	                    "selected": ""
	                }));
		    	}
		    }
			function getAddData() {
		        $.ajax({
		            cache: false,
		            type: "POST",
		            url: "<%=path%>/template/getAllData",
		            data: {},
		            async: false,
		            error: function(request) {
		                toastr.error("Server Connection Error...");
		            },
		            success: function(res) {
		            	$("#addModal input[name=templateId]").val(res.data[0].id);
		                $("#addtemplate_container").html(_.template($("#template_tpl").html())({
	                        "data": res.data,
	                        "tid": window.param.templateId
	                    }));
		            }
		        });
		        $.ajax({
                    cache: false,
                    type: "POST",
                    url: "<%=path%>/managers/getAllData",
                    data: {},
                    async: false,
                    error: function(request) {
                        toastr.error("Server Connection Error...");
                    },
                    success: function(res) {
                    	$("#addModal input[name=mid]").val(res.data[0].id);
                        $("#addmid_container").html(_.template($("#mid_tpl").html())({
                            "data": res.data,
                            "mid": window.param.mid
                        }));
                    }
                });
		    }
			function getEditData() {
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "<%=path%>/template/getAllData",
                    data: {},
                    async: false,
                    error: function(request) {
                        toastr.error("Server Connection Error...");
                    },
                    success: function(res) {
                        $("#edittemplate_container").html(_.template($("#template_tpl").html())({
                            "data": res.data,
                            "tid": window.param.templateId
                        }));
                    }
                });
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "<%=path%>/managers/getAllData",
                    data: {},
                    async: false,
                    error: function(request) {
                        toastr.error("Server Connection Error...");
                    },
                    success: function(res) {
                        $("#editmid_container").html(_.template($("#mid_tpl").html())({
                            "data": res.data,
                            "mid": window.param.mid
                        }));
                    }
                });
            }
	            function changeMid(id) {
	            	$("#addModal input[name=mid]").val(id);
	            	$("#editModal input[name=mid]").val(id);
	            	window.param.mid = id;
	            }
	            function changeTemplate(id) {
	            	$("#addModal input[name=templateId]").val(id);
	            	$("#editModal input[name=templateId]").val(id);
	            	window.param.templateId = id;
	            }
		</script>
	
		<!-- jQuery UI 1.11.4 -->
		<script src="<%=path%>/res/home/assets/js/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
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
		<script src="<%=path%>/res/jquery.qrcode.min.js"></script>
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

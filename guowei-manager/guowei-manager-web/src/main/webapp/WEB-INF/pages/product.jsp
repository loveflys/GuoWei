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
		<link rel="stylesheet" href="<%=path%>/res/fileupload.css">
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
       		<%@ include file="include/header.jsp" %>
			
			<!--menu-->
       		<%@ include file="include/menu.jsp" %>
	
			<!-- Left side column. contains the logo and sidebar -->
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
				
					<!-- 路径导航 -->
					<a href="<%=path%>/"><i class="fa fa-home"></i> <sp:message code="sys.home"/></a> > 
					<a href="<%=path%>/products"><sp:message code="menu.products"/></a>&nbsp;&nbsp;<small><sp:message code="product.list"/></small>
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
							    <button type="button" class="btn btn-primary btn-sm"  id="btn-add">
                                    <i class="fa fa-plus"></i> <sp:message code="sys.add"/>
                                </button>
								<button type="button" class="btn btn-primary btn-sm" id="btn-re">
									<i class="fa fa-refresh"></i> <sp:message code="sys.refresh"/>
								</button>
							</div>
						</div>

						<div class="row">
							<form id="queryForm" action="<%=path%>/products" method="post">
								<div class="col-xs-2">
									<input type="text" id="keyword" name="title" class="form-control input-sm"
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
												<th><sp:message code="product.title"/></th>
												<th><sp:message code="product.image"/></th>
												<th><sp:message code="product.price"/></th>
												<th><sp:message code="product.discountprice"/></th>
												<th><sp:message code="product.buyingprice"/></th>
												<th><sp:message code="product.stock"/></th>
												<th><sp:message code="product.distribute"/></th>
												<th><sp:message code="product.created"/></th>
												<th><sp:message code="product.updated"/></th>
												<th><sp:message code="product.allsellcount"/></th>
												<th><sp:message code="product.cid"/></th>
												<th><sp:message code="product.status"/></th>
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
		
		<!-- EditProduct -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><sp:message code="product.info"/>-<sp:message code="sys.edit"/></h4>
					</div>
					
					<div class="modal-body" >
						<form class="form-horizontal"  id="editForm" action="<%=path%>/product/update" method="post">
							<input type="hidden" class="form-control" name="id">
							<input type="hidden" class="form-control" name="sid">
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="product.title"/></label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="title" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.image"/></label>
                                <div class="col-sm-9">
                                    <input type="hidden" class="form-control" name="image">
                                    <div class="upload-img-btn update-file-btn">+</div>
                                    <input type="file" id="update-file" onchange="upload(2)" class="form-control hidden-file-input">
                                    <div class="upload-img-btn update-file-pre-div" style="display:none">
                                        <img id="update-file-pre" src="" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.price"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="price">
                                </div>
                            </div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="product.discountprice"/></label>
								<div class="col-sm-9">
									<input type="number" class="form-control" name="discountprice">
								</div>
							</div>	
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.buyingprice"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="buyingprice">
                                </div>
                            </div>          
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.stock"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="stock" readonly="readonly">
                                </div>
                            </div>   
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.distribute"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="distribute" readonly="readonly">
                                </div>
                            </div>           
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.created"/></label>

                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="created" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.updated"/></label>

                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="updated" readonly="readonly">
                                </div>
                            </div>         
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.allsellcount"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="allsellcount" readonly="readonly">
                                </div>
                            </div>          						
							
							<div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.cid"/></label>
                                <div class="col-sm-9">
                                <select class="form-control" name="cid" id="editcid_container"  onchange="changeCid(this.options[this.options.selectedIndex].value)">
    
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.status"/></label>

                                <div class="col-sm-9">
                                <select class="form-control" name="status" id="editstatus_container"  onchange="changeStatus(this.options[this.options.selectedIndex].value)">
    
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
	                            <label for="inputName" class="col-sm-3 control-label">供货商</label>
	                            <div class="col-sm-9">
	                                <select class="form-control" name="sid" id="editsid_container"  onchange="changesid(this.options[this.options.selectedIndex].value)">
	        
	                                </select>
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
	    <!-- AddProduct -->
        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" >
                <div class="modal-content">
                
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel"><sp:message code="product.info"/>-<sp:message code="sys.add"/></h4>
                    </div>
                    
                    <div class="modal-body" >
                        <form class="form-horizontal"  id="addForm" action="<%=path%>/product/add" method="post">
                            <input type="hidden" class="form-control" name="sid">
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.title"/></label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="title">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.image"/></label>
                                <div class="col-sm-9">
                                    <input type="hidden" class="form-control" name="image">
                                    <div class="upload-img-btn add-file-btn">+</div>
                                    <input type="file" id="add-file" onchange="upload(1)" class="form-control hidden-file-input">
                                    <div class="upload-img-btn add-file-pre-div" style="display:none">
                                        <img id="add-file-pre" src="" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.price"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="price">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.discountprice"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="discountprice">
                                </div>
                            </div>  
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.buyingprice"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="buyingprice">
                                </div>
                            </div>          
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.stock"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="stock">
                                </div>
                            </div>    
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.distribute"/></label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="distribute" value="0"  readonly="readonly">
                                </div>
                            </div>       
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.cid"/></label>

                                <div class="col-sm-9">
                                <select class="form-control" name="cid" id="addcid_container"  onchange="changeCid(this.options[this.options.selectedIndex].value)">
    
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputName" class="col-sm-3 control-label"><sp:message code="product.status"/></label>

                                <div class="col-sm-9">
                                <select class="form-control" name="status" id="addstatus_container"  onchange="changeStatus(this.options[this.options.selectedIndex].value)">
    
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
	                            <label for="inputName" class="col-sm-3 control-label">供货商</label>
	                            <div class="col-sm-9">
	                                <select class="form-control" name="sid" id="addsid_container"  onchange="changesid(this.options[this.options.selectedIndex].value)">
	        
	                                </select>
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
		<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">商品进货</h4>
				      </div>
				      <div class="modal-body">
				        <p>当前产品: <span id="now_proName"></span></p>
				        <div class="form-group">                                                        
                            <label for="inputName" class="col-sm-3 control-label">进货数量</label>
                            <div class="col-sm-9">
                                <input id="purchaseNum" type="number" class="form-control">
                            </div>
                        </div>
				        <div class="form-group">				            				            
                            <label for="inputName" class="col-sm-3 control-label">进货价</label>
                            <div class="col-sm-9">
                                <input id="purchasePrice" type="number" class="form-control">
                            </div>
                        </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="button" class="btn btn-primary" onclick="purchasePro()">确定</button>
				      </div>
				    </div>
				  </div>
				</div>
		<!-- page script -->
		<script type="template" id="sid_tpl">
            [[ for(var i=0; i< data.length; i++){ var item=data[i]; ]]
                [[ if (item.id == sid) { ]]
                    <option value="{{item.id}}" selected="selected">{{item.supplierName}}</option>
                [[ } else { ]]
                    <option value="{{item.id}}">{{item.supplierName}}</option>
                [[ } ]]
            [[ } ]]
        </script>
		<script type="template" id="cid_tpl">
            [[ for(var i=0; i< data.length; i++){ var item=data[i] ]]
                [[ if (item.id == cid) { ]]
                    <option value="{{item.id}}" selected="selected">{{item.name}}</option>
                [[ } else { ]]
                    <option value="{{item.id}}">{{item.name}}</option>
                [[ } ]]
            [[ } ]]
        </script>
        <script type="template" id="status_tpl">
            [[ if (1 == status) { ]]
                    <option value="1" selected="selected">上架</option>
                    <option value="2">下架</option>
                    <option value="3">删除</option>
            [[ } else if (2 == status) { ]]
                    <option value="1">上架</option>
                    <option value="2" selected="selected">下架</option>
                    <option value="3">删除</option>
            [[ } else { ]]
                    <option value="1">上架</option>
                    <option value="2">下架</option>
                    <option value="3" selected="selected">删除</option>
            [[ } ]]
        </script>
		<script>
		var tables = null;
		    window.param = {
		    	qiniuToken: '',
		    	qiniuUrl: '',
		    	id: '',
		    	status: '',
		    	cid: '',
		    	sid: '',
		    	purchaseProId: '',
		    }
		    function getToken () {
		    	var url = "<%=path%>/file/getToken";
                $.ajax({
                    cache: false,
                    type: "get",
                    url: url,
                    data: {},
                    async: false,
                    error: function(request) {
                        alert("Server Connection Error...");
                    },
                    success: function(ret) {
                    	if (ret.ok) {
                            window.param.qiniuToken = ret.token;
                            window.param.qiniuUrl = ret.url;
                        } else {
                            if (ret.msg) {
                                alert(ret.msg);
                            } else {
                            	alert("七牛token获取失败,请稍后再试。");
                            }
                        }
                    }
                });
		    }
		    function upload(type) {
		    	var files = null;
		    	if (type == 1) {
		    	    files = document.getElementById("add-file").files[0];
		    	} else {
		    		files = document.getElementById("update-file").files[0];
		    	}
		    	if (files === null || files === undefined) {
		    		toastr.error('请先选择文件。');
		            return;
		          }
		          if (files.size/(1024*1024) > 2) {
		        	toastr.error('文件' + files.name + ' 太大，不能超过 2M。');
		            return;
		          }

		          let oData = new FormData();
		          oData.append("file", files);
		          oData.append("token", window.param.qiniuToken);
		          var oReq = new XMLHttpRequest();
		          oReq.open( "POST", "http://up-z1.qiniu.com/" , true );
		          oReq.onload = function(oEvent) {
		            let res = JSON.parse(oReq.response);
		            if (oReq.status === 200 && res.key) {
		              let url = window.param.qiniuUrl + res.key;
		              if (type == 1) {
			              $(".add-file-btn").hide();
			              $(".add-file-pre-div").show();
			              $("#add-file-pre").attr('src', url);
			              $("#addModal input[name=image]").val(url);
		              } else {
		            	  $(".update-file-btn").hide();
                          $(".update-file-pre-div").show();
                          $("#update-file-pre").attr('src', url);
                          $("#editModal input[name=image]").val(url);
		              }
		            } else {
		              toastr.error('上传失败。');
		            }
		          };
		          oReq.onerror = function(err) {
		        	  toastr.error('上传错误。');
		          };
		          oReq.send(oData);
		    }
			$(function () {
				_.templateSettings = {
	                evaluate    : /\[\[(.+?)\]\]/g,
	                interpolate : /\{\{(.+?)\}\}/g
	            };
				getToken();
				//页面消息处理
				var result = "${result}";
		  		var msg= "${msg}";
		  		if(result == 1){
		  			alert(msg);
		  		}
		  		
		  		
				
				tables = $("#dataTable").dataTable({
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
			            url: "<%=path%>/product/getData",
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
	               		{"data": 'title', defaultContent: ""}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列	               		
	                    {"data": 'image', 
	               		    "render": function (data,type,full,callback) {
	               		    	return "<img src=\""+data+"\" width=\"50\" height=\"50\"/><label></label>";
	               		    }
	               		},
	                    {"data": 'price', defaultContent: ""},
  	                    {"data": 'discountprice', defaultContent: ""},
  	                    {"data": 'buyingprice', defaultContent: ""},
	  	                {"data": 'stock', defaultContent: ""},	  	
	  	                {"data": 'distribute', defaultContent: ""},    
  	                    {"data": 'created', 
  	                    	"render":function(data,type,full,callback) {
  	                    		return moment(data).format('YYYY-MM-DD') 
	                    	}
	               		},
	               		{"data": 'updated', 
                            "render":function(data,type,full,callback) {
                                return moment(data).format('YYYY-MM-DD') 
                            }
                        },
                        {"data": 'allsellcount', defaultContent: ""},
	               		{"data": 'cname', defaultContent: ""},
	               		{"data": 'status', 
                            "render": function(data,type,full,callback) {
                            	var res = '';
                            	if (data == 1) {
                            		res = '上架';
                            	} else if (data == 2) {
                                    res = '下架';
                                } if (data == 3) {
                                    res = '删除';
                                }
                                return res; 
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
		                    				"<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i></button></div>"+
		                    				"<button id='purchaseRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-plus-square'></i></button></div>"
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
	            	getAddData();
                    $("#addModal input[name=title]").val("");
                    $("input[name=price]").val("");
                    $("input[name=discountprice]").val("");
                    $("input[name=buyingprice]").val("");
                    $("input[name=stock]").val("");
                    $("input[name=distribute]").val("0");
                    $("input[name=allsellcount]").val("");
                    $("input[name=cid]").val("");
                    $("input[name=status]").val("");
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
	          	$("#dataTable tbody").on('click', '#purchaseRow', function () {
	          		var data = tables.api().row($(this).parents('tr')).data();
	          		//赋值到Modal上
	          		window.param.purchaseProId = data.id;
	          		$("#now_proName").html(data.title);
	          		$("#purchasePrice").val(data.buyingprice)
	          		$("#myModal").modal('show');
	          	})
	          	//修改 Model
				$('#dataTable tbody').on( 'click', '#editRow', function () {
					var data = tables.api().row($(this).parents('tr')).data();
					$("input[name=id]").val(data.id);
					
					window.param.id = data.id;
                    window.param.cid = data.cid;
                    window.param.sid = data.sid;
                    window.param.status = data.status;
                    getEditData();
					
					$("#editModal input[name=title]").val(data.title);
					$("input[name=price]").val(data.price);
					$(".update-file-btn").hide();
                    $(".update-file-pre-div").show();
                    $("#update-file-pre").attr('src', data.image);
                    $("#editModal input[name=image]").val(data.image);
					$("input[name=discountprice]").val(data.discountprice);
					$("input[name=buyingprice]").val(data.buyingprice);
					$("input[name=stock]").val(data.stock);
					$("input[name=distribute]").val(data.distribute);
					if (!data.created || data.created.length <= 0) {
						$("input[name=created]").val(moment(new Date()).format('YYYY-MM-DD'));
					} else {
						$("input[name=created]").val(moment(new Date(data.created)).format('YYYY-MM-DD'));
					}
                    if (!data.updated || data.updated.length <= 0) {
                        $("input[name=updated]").val(moment(new Date()).format('YYYY-MM-DD'));
                    } else {
                        $("input[name=updated]").val(moment(new Date(data.updated)).format('YYYY-MM-DD'));
                    }
					$("input[name=allsellcount]").val(data.allsellcount);
					$("#editModal").modal("show");
					
		        });
	          	
				$("#btn-submit").on("click", function(){
					var url = "<%=path%>/product/update";
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
                    var url = "<%=path%>/product/add";
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
		                    url:'<%=path%>/product/del/'+data.id,
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
				function getAddData() {
	                $.ajax({
	                    cache: false,
	                    type: "POST",
	                    url: "<%=path%>/category/getAllData",
	                    data: {},
	                    async: false,
	                    error: function(request) {
	                        toastr.error("Server Connection Error...");
	                    },
	                    success: function(res) {
	                        $("#addModal input[name=cid]").val(res.data[0].id);
	                        $("#addcid_container").html(_.template($("#cid_tpl").html())({
	                            "data": res.data,
	                            "cid": window.param.cid
	                        }));
	                    }
	                });
	                $("#addModal input[name=status]").val(1);
                    $("#addstatus_container").html(_.template($("#status_tpl").html())({
                        "status": 1
                    }));
                    
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
                            $("#addModal input[name=sid]").val(res.data[0].id);
                            $("#addsid_container").html(_.template($("#sid_tpl").html())({
                                "data": res.data,
                                "sid": window.param.sid
                            }));
                        }
                    });
	            }
	            function getEditData() {
	                $.ajax({
	                    cache: false,
	                    type: "POST",
	                    url: "<%=path%>/category/getAllData",
	                    data: {},
	                    async: false,
	                    error: function(request) {
	                        toastr.error("Server Connection Error...");
	                    },
	                    success: function(res) {
	                        $("#editcid_container").html(_.template($("#cid_tpl").html())({
	                            "data": res.data,
	                            "cid": window.param.cid
	                        }));
	                    }
	                });
	                $("#editstatus_container").html(_.template($("#status_tpl").html())({
                        "status": window.param.status
                    }));
	                
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
	                        $("#editModal input[name=sid]").val(window.param.sid);
	                        $("#editsid_container").html(_.template($("#sid_tpl").html())({
	                            "data": res.data,
	                            "sid": window.param.sid
	                        }));
	                    }
	                });
	            }
			});
			function changeCid(id) {
                $("#addModal input[name=cid]").val(id);
                $("#editModal input[name=cid]").val(id);
                window.param.cid = id;
            }
            function changesid(id) {
                $("#addModal input[name=sid]").val(id);
                $("#editModal input[name=sid]").val(id);
                window.param.sid = id;
            }
            function changeStatus(id) {
                $("#addModal input[name=status]").val(id);
                $("#editModal input[name=status]").val(id);
                window.param.status = id;
            }
			function purchasePro () {
				$.ajax({
                    url:'<%=path%>/product/addPurchase/',
                    type:'POST',
                    data: {
                    	id: window.param.purchaseProId,
                    	purchaseNum: $("#purchaseNum").val(),
                    	purchasePrice: $("#purchasePrice").val()
                    },
                    //timeout:"3000",
                    cache:"false",
                    success:function(data){
                        if(data.status == 1){
                        	//var $toast = toastr['info']('<sp:message code='sys.oper.success'/>');
                        	toastr.success("<sp:message code='sys.oper.success'/>");
                        	tables.fnDraw(false);
                        	$("#myModal").modal('hide');
                        }else{
                        	toastr.error("<sp:message code='sys.oper.success'/>");
                        }
                    },
                    error:function(err){
                    	toastr.error("Server Connection Error...");
                    }
                });
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
		<!-- FastClick -->
		<script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
		<script src="<%=path%>/res/home/assets/js/underscore.min.js"></script>
		<!-- AdminLTE App -->
		<script src="<%=path%>/res/dist/js/app.min.js"></script>
		<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
		<script src="<%=path%>/res/dist/js/pages/dashboard.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="<%=path%>/res/dist/js/demo.js"></script>
	</body>
</html>

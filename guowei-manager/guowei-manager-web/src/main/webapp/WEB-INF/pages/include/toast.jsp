<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
%>
<link rel="stylesheet" href="<%=path%>/res/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/res/plugins/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path%>/res/toastr/toastr.min.css">
<link rel="stylesheet" href="<%=path%>/res/sweetalert/sweetalert.css">
<script src="<%=path%>/res/toastr/toastr.min.js"></script>
<script src="<%=path%>/res/sweetalert/sweetalert.min.js"></script>
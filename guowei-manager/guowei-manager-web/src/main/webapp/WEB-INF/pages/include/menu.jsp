<%@ page language="java" pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<section class="sidebar">
		<!-- Sidebar user panel 菜单用户信息 -->

		<!-- search form -->
		<!-- /.search form -->
		
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><sp:message code="menu"/></li>
			<li class="treeview">
				<a href="<%=path%>/managers"> <i class="fa fa-user"></i><span><sp:message code="menu.manager"/></span></a>
				<a href="<%=path%>/users"> <i class="fa fa-user"></i><span><sp:message code="menu.users"/></span></a>
				<a href="<%=path%>/categorys"> <i class="fa fa-user"></i><span><sp:message code="menu.cates"/></span></a>
				<a href="<%=path%>/products"> <i class="fa fa-user"></i><span><sp:message code="menu.products"/></span></a>
				<a href="<%=path%>/companys"> <i class="fa fa-user"></i><span><sp:message code="menu.companys"/></span></a>
				<a href="<%=path%>/orders"> <i class="fa fa-user"></i><span><sp:message code="menu.orders"/></span></a>
				<a href="<%=path%>/divisions"> <i class="fa fa-user"></i><span><sp:message code="menu.divisions"/></span></a>
			</li>
		</ul>
	</section>
</aside>
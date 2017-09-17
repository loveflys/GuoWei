<%@ page language="java" pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header"><sp:message code="menu"/></li>
			<li class="treeview">
                <a href="<%=path%>/managerindex"> <i class="fa fa-user"></i><span><sp:message code="sys.home" /></span></a>
            </li>
			<li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
				<a href="<%=path%>/managerlist"> <i class="fa fa-user"></i><span><sp:message code="menu.manager"/></span></a>
			</li>
			<li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/carousels"> <i class="fa fa-user"></i><span><sp:message code="menu.carousel"/></span></a>
            </li>
			<li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/applys"> <i class="fa fa-user"></i><span><sp:message code="apply.list"/></span></a>
            </li>
            <li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/complains"> <i class="fa fa-user"></i><span><sp:message code="complain.list"/></span></a>
            </li>
			<li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/users"> <i class="fa fa-user"></i><span><sp:message code="menu.users"/></span></a>
            </li>
            <li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/categorys"> <i class="fa fa-user"></i><span><sp:message code="menu.categorys"/></span></a>
            </li>
            <li class="treeview">
                <a href="<%=path%>/templates"> <i class="fa fa-user"></i><span><sp:message code="menu.templates"/></span></a>
            </li>
            <li class="treeview">
                <a href="<%=path%>/products"> <i class="fa fa-user"></i><span><sp:message code="menu.products"/></span></a>
            </li>
            <li class="treeview">
                <a href="<%=path%>/companys"> <i class="fa fa-user"></i><span><sp:message code="menu.companys"/></span></a>
            </li>
            <li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/suppliers"> <i class="fa fa-user"></i><span><sp:message code="menu.suppliers"/></span></a>
            </li>
            <li class="treeview">
                <a href="<%=path%>/orders"> <i class="fa fa-user"></i><span><sp:message code="menu.orders"/></span></a>
            </li>
            <li class="treeview" style="display: ${currentUser.level == 3?'block':'none'}">
                <a href="<%=path%>/divisions"> <i class="fa fa-user"></i><span><sp:message code="menu.divisions"/></span></a>
            </li>               
		</ul>
	</section>
</aside>
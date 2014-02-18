<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%  
String path = request.getContextPath();  
String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">切换导航</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#logo">Dendnight</a>
		</div>
		<div class="collapse navbar-collapse">
			<s:if test="#session.loginInfo != null">
				<ul class="nav navbar-nav">
					<li id="m_index"><a href="<%= url %>to-index.htm">首页</a></li>
					<s:if test="#session.loginInfo.userType == 'UT_COMMON' || #session.loginInfo.userType == 'UT_SPECIAL'">
						<li id="m_create"><a href="<%= url %>to-create.htm">新建</a></li>
						<li id="m_list"><a href="<%= url %>to-list.htm">浏览</a></li>
					</s:if>
					<s:if test="#session.loginInfo.userType == 'UT_SPECIAL'">
						<li id="m_review"><a href="<%= url %>rv/task-list.htm">检阅</a></li>
					</s:if>
					<s:if test="#session.loginInfo.userType == 'UT_ADMIN'">
						<li id="m_manage"><a href="<%= url %>admin/list.htm">管理</a></li>
					</s:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span class="glyphicon glyphicon-user"></span>
							<s:property value="#session.loginInfo.realname"/>
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="<%= url %>to-update-password.htm">修改密码</a></li>
							<li class="divider"></li>
							<li><a href="<%= url %>logout.htm">安全退出</a></li>
						</ul>
					</li>
				</ul>
			</s:if>
		</div>
	</div>
</div>
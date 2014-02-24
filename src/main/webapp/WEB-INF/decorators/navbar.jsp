<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
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
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">gallery</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%-- 判断是否登录，未登录的只有登录 --%>
				<s:if test="null == #session.loginInfo || null == #session.loginInfo.nickname">
				<li><a href="#" data-toggle="modal" data-target="#modal-login">登录</a></li>
				<!-- Modal -->
				<div class="modal fade" id="modal-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">登录</h4>
				      </div>
				      <div class="modal-body">
				        ...
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				        <button type="button" class="btn btn-primary">登录</button>
				      </div>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				</s:if>
				<s:else>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						<s:property value="#session.loginInfo.nickname" />
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="<%=url%>to-update-password.htm">修改密码</a></li>
						<li class="divider"></li>
						<li><a href="<%=url%>logout.htm">安全退出</a></li>
					</ul>
				</li>
				</s:else>
			</ul>
		</div>
	</div>
</div>
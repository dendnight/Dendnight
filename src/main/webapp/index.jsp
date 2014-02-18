<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
<html>
<body>
	<h2>Hello World!</h2>
	<div class="panel panel-default">
		<div class="panel-body">
			<div style="display: none; text-align: center;" class="alert"></div>
			<h2>
				Hi!
				<s:property value="#session.loginInfo.realname" />
				<s:if test="#session.loginInfo.userType == 'UT_COMMON'">
					<button type="button" data-loading-text="提交中..."
						class="btn btn-default pull-right">
						<i class="glyphicon glyphicon-cloud-upload"></i> <span>提交当天任务</span>
					</button>
				</s:if>
			</h2>
			<div id='calendar'></div>
			<div style="height: 50px"></div>
		</div>
	</div>
</body>
</html>

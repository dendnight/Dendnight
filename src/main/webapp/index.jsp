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
	<div class="panel panel-default">
		<div class="panel-body">
			<div style="display: none; text-align: center;" class="alert"></div>
			<h2>Hi!</h2>
			<input type="file" />
			<button type="button" data-loading-text="提交中..."
				class="btn btn-default pull-right">
				<i class="glyphicon glyphicon-cloud-upload"></i> <span>上传</span>
			</button>
			<div style="height: 500px"></div>
		</div>
	</div>
</body>
</html>

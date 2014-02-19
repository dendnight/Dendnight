<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		// 提交表单
		$(".btn-primary").click(function() {
			$("#login-form").ajaxSubmit(function(data) {
				//alert(data.m);
				if (data.s) {
					alert("登录成功");
				}
			});
			return false;
		});

	});
</script>
</head>

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
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="login-form" action="<%=url%>login.htm" method="post">
						<br />
						<div style="display: none;" class="alert"></div>
						<div class="form-group">
							<input type="text" class="form-control" name="username"
								autocomplete="off" placeholder="帐号" required autofocus>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								autocomplete="off" placeholder="密码" required>
						</div>
						<br />
						<button id="login-btn" type="submit" data-loading-text="验证中..."
							class="btn btn-primary btn-block btn-lg">登 录</button>
					</form>
				</div>
			</div>

			<div style="height: 500px"></div>
		</div>
	</div>
</body>
</html>

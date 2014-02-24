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
		$(".login-submit").click(function() {
			$("#login-form").ajaxSubmit(function(data) {
				if (data.s) {
					window.location.href="<%= url %>upload.jsp";
					return;
				}
				alert(data.m);
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

			<div class="panel panel-default">
				<div class="panel-body">
					<form id="login-form" action="<%= url %>login.htm" method="post">
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
						<button id="login-submit" type="submit" data-loading-text="验证中..."
							class="btn btn-primary btn-block btn-lg">登 录</button>
					</form>
				</div>
			</div>

			<div style="height: 500px"></div>
			<a href="#" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
		</div>
	</div>
</body>
</html>
